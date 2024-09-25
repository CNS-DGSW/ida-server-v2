package com.daegusw.apply.core.excel.style.border

import org.apache.poi.ss.usermodel.CellStyle

interface ExcelBorders {
    fun apply(cellStyle: CellStyle)
}