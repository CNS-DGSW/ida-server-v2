package com.dgswiphak.ida.common.excel.resource

import com.dgswiphak.ida.common.annotation.DefaultBodyStyle
import com.dgswiphak.ida.common.annotation.DefaultHeaderStyle
import com.dgswiphak.ida.common.annotation.ExcelColumn
import com.dgswiphak.ida.common.annotation.ExcelColumnStyle
import com.dgswiphak.ida.common.excel.ExcelCellStyle
import com.dgswiphak.ida.common.excel.resource.collection.PreCalculatedCellStyleMap
import com.dgswiphak.ida.common.excel.utils.SuperClassReflectionUtils.getAllFields
import com.dgswiphak.ida.common.excel.utils.SuperClassReflectionUtils.getAnnotation
import org.apache.poi.ss.usermodel.Workbook

class ExcelRenderResourceFactory {

    fun prepareRenderResource(type: Class<*>, wb: Workbook, dataFormatDecider: DataFormatDecider): ExcelRenderResource {
        val styleMap = PreCalculatedCellStyleMap(dataFormatDecider)
        val headerNamesMap = LinkedHashMap<String, String>()
        val fieldNames = mutableListOf<String>()
        var cellWidth = 1024

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
                cellWidth = annotation.width
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
        val excelCellStyleClass = Class.forName(excelColumnStyle.excelCellStyleClass)

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