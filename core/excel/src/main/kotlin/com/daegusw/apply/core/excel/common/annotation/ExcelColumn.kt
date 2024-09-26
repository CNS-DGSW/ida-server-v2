package com.daegusw.apply.core.excel.common.annotation

import com.daegusw.apply.core.excel.style.DefaultBodyCellStyle
import com.daegusw.apply.core.excel.style.DefaultHeaderCellStyle

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ExcelColumn(
    val headerName: String = "",
    val width: Int = 1024,
    val headerStyle: ExcelColumnStyle = ExcelColumnStyle(excelCellStyleClass = DefaultHeaderCellStyle::class),
    val bodyStyle: ExcelColumnStyle = ExcelColumnStyle(excelCellStyleClass = DefaultBodyCellStyle::class)
)