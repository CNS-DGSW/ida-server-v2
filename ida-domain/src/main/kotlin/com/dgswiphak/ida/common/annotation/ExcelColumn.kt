package com.dgswiphak.ida.common.annotation

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ExcelColumn(
    val headerName: String = "",
    val width: Int = 1024,
    val headerStyle: ExcelColumnStyle = ExcelColumnStyle(excelCellStyleClass = "com.dgswiphak.ida.common.excel.NoExcelCellStyle"),
    val bodyStyle: ExcelColumnStyle = ExcelColumnStyle(excelCellStyleClass = "com.dgswiphak.ida.common.excel.NoExcelCellStyle")
)