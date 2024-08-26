package com.dgswiphak.ida.common.excel.style.color

import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.FillPatternType
import org.apache.poi.xssf.usermodel.DefaultIndexedColorMap
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFColor
import java.lang.RuntimeException

class DefaultExcelColor(
    private val red: Byte,
    private val green: Byte,
    private val blue: Byte
) : ExcelColor {

    companion object {
        private const val MIN_RGB = 0
        private const val MAX_RGB = 255

        fun rgb(red: Int, green: Int, blue: Int): DefaultExcelColor {
            if (red < MIN_RGB || red > MAX_RGB || green < MIN_RGB || green > MAX_RGB || blue < MIN_RGB || blue > MAX_RGB) {
                throw IllegalArgumentException("Wrong RGB($red $green $blue)")
            }
            return DefaultExcelColor(red.toByte(), green.toByte(), blue.toByte())
        }
    }

    override fun apply(cellStyle: CellStyle) {
        try {
            val xssfCellStyle = cellStyle as XSSFCellStyle
            xssfCellStyle.setFillForegroundColor(XSSFColor(byteArrayOf(red, green, blue), DefaultIndexedColorMap()))
        } catch (e: Exception) {
            throw RuntimeException("Excel Type ${cellStyle.javaClass} is not supported now")
        }
        cellStyle.fillPattern = FillPatternType.SOLID_FOREGROUND
    }
}
