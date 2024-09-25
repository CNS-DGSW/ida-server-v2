package com.daegusw.apply.core.excel.style.align

import org.apache.poi.ss.usermodel.CellStyle

class NoExcelAlign : ExcelAlign {
    override fun apply(cellStyle: CellStyle) {
        //Do Nothing
    }
}