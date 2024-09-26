package com.daegusw.apply.core.excel.resource

import com.daegusw.apply.core.excel.common.annotation.DefaultBodyStyle
import com.daegusw.apply.core.excel.common.annotation.DefaultHeaderStyle
import com.daegusw.apply.core.excel.common.annotation.ExcelColumn
import com.daegusw.apply.core.excel.common.annotation.ExcelColumnStyle
import com.daegusw.apply.core.excel.common.file.ExcelCellStyle
import com.daegusw.apply.core.excel.resource.collection.PreCalculatedCellStyleMap
import com.daegusw.apply.core.excel.utils.SuperClassReflectionUtils.getAllFields
import com.daegusw.apply.core.excel.utils.SuperClassReflectionUtils.getAnnotation
import org.apache.poi.ss.usermodel.Workbook

class ExcelRenderResourceFactory {

    fun prepareRenderResource(type: Class<*>, wb: Workbook, dataFormatDecider: DataFormatDecider): ExcelRenderResource {
        val styleMap = PreCalculatedCellStyleMap(dataFormatDecider)
        val headerNamesMap = LinkedHashMap<String, String>()
        val fieldNames = mutableListOf<String>()
        val cellWidth = mutableListOf<Int>()

        val classDefinedHeaderStyle = getHeaderExcelColumnStyle(type)
        val classDefinedBodyStyle = getBodyExcelColumnStyle(type)


        for (field in getAllFields(type)) {
            if (field.isAnnotationPresent(ExcelColumn::class.java)) {
                val annotation = field.getAnnotation(ExcelColumn::class.java)
                styleMap.put(
                    String::class.java,
                    ExcelCellKey.of(field.name, ExcelRenderLocation.HEADER),
                    getCellStyle(decideAppliedStyleAnnotation(classDefinedHeaderStyle, annotation.headerStyle)), wb
                )
                val fieldType = field.type
                styleMap.put(
                    fieldType,
                    ExcelCellKey.of(field.name, ExcelRenderLocation.BODY),
                    getCellStyle(decideAppliedStyleAnnotation(classDefinedBodyStyle, annotation.bodyStyle)), wb
                )
                fieldNames.add(field.name)
                headerNamesMap[field.name] = annotation.headerName
                cellWidth.add(annotation.width)
            }
        }

        if (styleMap.isEmpty()) {
            throw RuntimeException("Class $type has not @ExcelColumn at all")
        }
        return ExcelRenderResource(styleMap, headerNamesMap, fieldNames, cellWidth)
    }

    private fun getHeaderExcelColumnStyle(clazz: Class<*>): ExcelColumnStyle? {
        val annotation = getAnnotation(clazz, DefaultHeaderStyle::class.java) ?: return null
        return (annotation as DefaultHeaderStyle).style
    }

    private fun getBodyExcelColumnStyle(clazz: Class<*>): ExcelColumnStyle? {
        val annotation = getAnnotation(clazz, DefaultBodyStyle::class.java) ?: return null
        return (annotation as DefaultBodyStyle).style
    }

    private fun decideAppliedStyleAnnotation(
        classAnnotation: ExcelColumnStyle?,
        fieldAnnotation: ExcelColumnStyle
    ): ExcelColumnStyle {
        return classAnnotation ?: fieldAnnotation
    }

    private fun getCellStyle(excelColumnStyle: ExcelColumnStyle): ExcelCellStyle {
        val excelCellStyleClass = excelColumnStyle.excelCellStyleClass.java

        if (excelCellStyleClass.isEnum) {
            val enumName = excelColumnStyle.enumName
            return findExcelCellStyle(excelCellStyleClass, enumName)
        }

        return try {
            excelCellStyleClass.getDeclaredConstructor().newInstance() as ExcelCellStyle
        } catch (e: InstantiationException) {
            throw RuntimeException(e.message, e)
        } catch (e: IllegalAccessException) {
            throw RuntimeException(e.message, e)
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun findExcelCellStyle(excelCellStyles: Class<*>, enumName: String): ExcelCellStyle {
        return try {
            val enumClass = excelCellStyles as Class<out Enum<*>>
            java.lang.Enum.valueOf(enumClass, enumName) as ExcelCellStyle
        } catch (e: NullPointerException) {
            throw RuntimeException("enumName must not be null", e)
        } catch (e: IllegalArgumentException) {
            throw RuntimeException(
                "Enum ${excelCellStyles.name} does not name $enumName", e
            )
        }
    }


}