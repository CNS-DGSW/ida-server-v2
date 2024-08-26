package com.dgswiphak.ida.common.excel.style

import com.dgswiphak.ida.common.excel.style.align.DefaultExcelAlign
import com.dgswiphak.ida.common.excel.style.align.ExcelStyle
import com.dgswiphak.ida.common.excel.style.border.DefaultExcelBorders
import com.dgswiphak.ida.common.excel.style.border.ExcelBorderStyle
import com.dgswiphak.ida.common.excel.style.config.ExcelCellStyleConfigurer

class DefaultBodyCellStyle : CustomExcelCellStyle() {
    override fun configure(configurer: ExcelCellStyleConfigurer) {
        configurer.foregroundColor(255, 255, 255)
            .excelAlign(DefaultExcelAlign.align(ExcelStyle.CENTER_CENTER))
            .excelBorders(DefaultExcelBorders.newInstance(ExcelBorderStyle.THIN))
    }
}