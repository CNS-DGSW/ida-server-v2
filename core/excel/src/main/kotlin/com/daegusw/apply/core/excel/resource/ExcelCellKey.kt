package com.daegusw.apply.core.excel.resource

data class ExcelCellKey(
    val dataFieldName: String,
    val excelRenderLocation: ExcelRenderLocation
) {
    companion object {
        fun of(fieldName: String, excelRenderLocation: ExcelRenderLocation): ExcelCellKey {
            return ExcelCellKey(fieldName, excelRenderLocation)
        }
    }
}