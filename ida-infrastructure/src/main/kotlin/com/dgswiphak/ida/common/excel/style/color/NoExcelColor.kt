package com.dgswiphak.ida.common.excel.style.color

import org.apache.poi.ss.usermodel.CellStyle

class NoExcelColor : ExcelColor {
    override fun apply(cellStyle: CellStyle) {
        //Do Nothing
    }
}