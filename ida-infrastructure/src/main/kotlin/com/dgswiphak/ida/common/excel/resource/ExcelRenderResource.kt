package com.dgswiphak.ida.common.excel.resource

import com.dgswiphak.ida.common.excel.resource.collection.PreCalculatedCellStyleMap
import org.apache.poi.ss.usermodel.CellStyle

class ExcelRenderResource(
    private val styleMap: PreCalculatedCellStyleMap,
    private val excelHeaderNames: Map<String, String>,
    private val dataFieldNames: List<String>,
    private val width: List<Int>
) {

    fun getCellStyle(dataFieldName: String, excelRenderLocation: ExcelRenderLocation): CellStyle? {
        return styleMap[ExcelCellKey.of(dataFieldName, excelRenderLocation)]
    }

    fun getExcelHeaderName(dataFieldName: String?): String? {
        return excelHeaderNames[dataFieldName]
    }

    fun getDataFieldNames(): List<String> {
        return dataFieldNames
    }

    fun getSellWidth(): List<Int> {
        return width
    }
}