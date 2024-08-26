package com.dgswiphak.ida.common.excel.style.color

import org.apache.poi.ss.usermodel.CellStyle

interface ExcelColor {
    fun apply(cellStyle: CellStyle)
}