package com.daegusw.apply.core.excel.style.align

import org.apache.poi.ss.usermodel.CellStyle

interface ExcelAlign {
    fun apply(cellStyle: CellStyle)
}