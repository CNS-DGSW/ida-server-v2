package com.daegusw.apply.core.excel.style.align

import org.apache.poi.ss.usermodel.CellStyle

class DefaultExcelAlign(
    private val excelStyle: ExcelStyle
): ExcelAlign {

    companion object {
        fun align(excelStyle: ExcelStyle) : DefaultExcelAlign {
            return DefaultExcelAlign(excelStyle)
        }

    }

    override fun apply(cellStyle: CellStyle) {
        cellStyle.alignment = excelStyle.horizontalAlignment
        cellStyle.verticalAlignment = excelStyle.verticalAlignment
    }
}