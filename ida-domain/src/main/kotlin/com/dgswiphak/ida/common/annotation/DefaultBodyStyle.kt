package com.dgswiphak.ida.common.annotation


@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultBodyStyle(
    val style: ExcelColumnStyle
)