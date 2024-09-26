package com.daegusw.apply.core.excel.style.color

import org.apache.poi.ss.usermodel.CellStyle

class NoExcelColor : ExcelColor {
    override fun apply(cellStyle: CellStyle) {
        //Do Nothing
    }
}