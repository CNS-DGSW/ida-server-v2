package com.dgswiphak.ida.common.excel.style.border

import org.apache.poi.ss.usermodel.CellStyle

class NoExcelBorders : ExcelBorders {
    override fun apply(cellStyle: CellStyle) {
        //Do Nothing
    }
}