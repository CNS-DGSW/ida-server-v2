package com.dgswiphak.ida.common.excel.resource

data class ExcelCellKey(
    val dataFieldName: String,
    val excelRenderLocation: ExcelRenderLocation
) {
    companion object {
        fun of(fieldName: String, excelRenderLocation: ExcelRenderLocation): ExcelCellKey {
            requireNotNull(excelRenderLocation) { "excelRenderLocation must not be null" }
            return ExcelCellKey(fieldName, excelRenderLocation)
        }
    }
}