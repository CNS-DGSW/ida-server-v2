package com.dgswiphak.ida.common.excel.style.border

import org.apache.poi.ss.usermodel.CellStyle

class DefaultExcelBorder(
    private val borderStyle : ExcelBorderStyle
) : ExcelBorder {
    override fun applyTop(cellStyle: CellStyle) {
        cellStyle.borderTop = borderStyle.borderStyle
    }

    override fun applyRight(cellStyle: CellStyle) {
        cellStyle.borderRight = borderStyle.borderStyle
    }

    override fun applyBottom(cellStyle: CellStyle) {
        cellStyle.borderBottom = borderStyle.borderStyle
    }

    override fun applyLeft(cellStyle: CellStyle) {
        cellStyle.borderLeft = borderStyle.borderStyle
    }
}