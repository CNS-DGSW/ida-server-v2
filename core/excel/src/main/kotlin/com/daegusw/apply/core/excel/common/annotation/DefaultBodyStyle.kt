package com.daegusw.apply.core.excel.common.annotation


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultBodyStyle(
    val style: ExcelColumnStyle
)