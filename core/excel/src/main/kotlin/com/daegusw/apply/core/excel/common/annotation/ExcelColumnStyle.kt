package com.daegusw.apply.core.excel.common.annotation

import com.daegusw.apply.core.excel.common.file.ExcelCellStyle
import kotlin.reflect.KClass


annotation class ExcelColumnStyle(
    val excelCellStyleClass: KClass<out ExcelCellStyle>,

    val enumName: String = ""
)