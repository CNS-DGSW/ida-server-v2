package com.daegusw.apply.core.excel.common.annotation


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultHeaderStyle(
    val style: ExcelColumnStyle
)