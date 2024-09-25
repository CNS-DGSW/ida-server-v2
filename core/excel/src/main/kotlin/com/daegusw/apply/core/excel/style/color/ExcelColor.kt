package com.daegusw.apply.core.excel.style.color

import org.apache.poi.ss.usermodel.CellStyle

interface ExcelColor {
    fun apply(cellStyle: CellStyle)
}