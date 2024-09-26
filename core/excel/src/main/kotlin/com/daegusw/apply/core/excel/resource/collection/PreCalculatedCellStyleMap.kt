package com.daegusw.apply.core.excel.resource.collection

import com.daegusw.apply.core.excel.common.file.ExcelCellStyle
import com.daegusw.apply.core.excel.resource.DataFormatDecider
import com.daegusw.apply.core.excel.resource.ExcelCellKey
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Workbook

class PreCalculatedCellStyleMap(
    private val dataFormatDecider : DataFormatDecider
) {

    private val cellStyleMap: MutableMap<ExcelCellKey, CellStyle> = HashMap()

    fun put(fieldType: Class<*>, excelCellKey: ExcelCellKey, excelCellStyle: ExcelCellStyle, wb: Workbook) {
        val cellStyle = wb.createCellStyle()
        val dataFormat = wb.createDataFormat()
        cellStyle.dataFormat = dataFormatDecider.getDataFormat(dataFormat, fieldType)
        excelCellStyle.apply(cellStyle)
        cellStyleMap[excelCellKey] = cellStyle
    }

    operator fun get(excelCellKey: ExcelCellKey): CellStyle? {
        return cellStyleMap[excelCellKey]
    }

    fun isEmpty(): Boolean {
        return cellStyleMap.isEmpty()
    }

}