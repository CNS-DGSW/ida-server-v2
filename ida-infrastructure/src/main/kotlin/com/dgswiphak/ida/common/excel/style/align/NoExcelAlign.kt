package com.dgswiphak.ida.common.excel.style.align

import org.apache.poi.ss.usermodel.CellStyle

class NoExcelAlign : ExcelAlign {
    override fun apply(cellStyle: CellStyle) {
        //Do Nothing
    }
}