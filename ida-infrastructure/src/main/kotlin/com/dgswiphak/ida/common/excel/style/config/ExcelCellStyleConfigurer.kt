가package com.dgswiphak.ida.common.excel.style.config

import com.dgswiphak.ida.common.excel.style.align.ExcelAlign
import com.dgswiphak.ida.common.excel.style.align.NoExcelAlign
import com.dgswiphak.ida.common.excel.style.border.ExcelBorders
import com.dgswiphak.ida.common.excel.style.border.NoExcelBorders
import com.dgswiphak.ida.common.excel.style.color.DefaultExcelColor
import com.dgswiphak.ida.common.excel.style.color.ExcelColor
import com.dgswiphak.ida.common.excel.style.color.NoExcelColor
import org.apache.poi.ss.usermodel.CellStyle

class ExcelCellStyleConfigurer {

    private var excelAlign: ExcelAlign = NoExcelAlign()
    private var foregroundColor: ExcelColor = NoExcelColor()
    private var excelBorders: ExcelBorders = NoExcelBorders()

    fun excelAlign(excelAlign: ExcelAlign): ExcelCellStyleConfigurer {
        this.excelAlign = excelAlign
        return this
    }

    fun foregroundColor(red: Int, blue: Int, green: Int): ExcelCellStyleConfigurer {
        this.foregroundColor = DefaultExcelColor.rgb(red, blue, green)
        return this
    }

    fun excelBorders(excelBorders: ExcelBorders): ExcelCellStyleConfigurer {
        this.excelBorders = excelBorders
        return this
    }

    fun configure(cellStyle: CellStyle) {
        excelAlign.apply(cellStyle)
        foregroundColor.apply(cellStyle)
        excelBorders.apply(cellStyle)
    }
}

