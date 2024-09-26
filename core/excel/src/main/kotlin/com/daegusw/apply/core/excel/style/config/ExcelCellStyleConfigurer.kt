package com.daegusw.apply.core.excel.style.config

import com.daegusw.apply.core.excel.style.align.ExcelAlign
import com.daegusw.apply.core.excel.style.align.NoExcelAlign
import com.daegusw.apply.core.excel.style.border.ExcelBorders
import com.daegusw.apply.core.excel.style.border.NoExcelBorders
import com.daegusw.apply.core.excel.style.color.DefaultExcelColor
import com.daegusw.apply.core.excel.style.color.ExcelColor
import com.daegusw.apply.core.excel.style.color.NoExcelColor
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

