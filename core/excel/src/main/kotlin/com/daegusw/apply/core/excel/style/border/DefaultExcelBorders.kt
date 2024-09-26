package com.daegusw.apply.core.excel.style.border

import org.apache.poi.ss.usermodel.CellStyle

class DefaultExcelBorders(
    private val borders: List<ExcelBorder>
) : ExcelBorders {

    companion object {
        fun newInstance(style: ExcelBorderStyle): DefaultExcelBorders {
            val excelBorders = MutableList(4) { DefaultExcelBorder(style) }
            return DefaultExcelBorders(excelBorders)
        }
    }

    override fun apply(cellStyle: CellStyle) {
        borders[0].applyTop(cellStyle)
        borders[1].applyRight(cellStyle)
        borders[2].applyBottom(cellStyle)
        borders[3].applyLeft(cellStyle)
    }
}
