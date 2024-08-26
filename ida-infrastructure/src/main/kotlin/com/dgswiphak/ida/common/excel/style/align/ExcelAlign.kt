package com.dgswiphak.ida.common.excel.style.align

import org.apache.poi.ss.usermodel.CellStyle

interface ExcelAlign {
    fun apply(cellStyle: CellStyle)
}