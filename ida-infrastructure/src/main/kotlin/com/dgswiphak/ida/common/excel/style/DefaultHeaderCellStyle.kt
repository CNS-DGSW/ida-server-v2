package com.dgswiphak.ida.common.excel.style

import com.dgswiphak.ida.common.excel.style.align.DefaultExcelAlign
import com.dgswiphak.ida.common.excel.style.align.ExcelStyle
import com.dgswiphak.ida.common.excel.style.border.DefaultExcelBorders
import com.dgswiphak.ida.common.excel.style.border.ExcelBorderStyle
import com.dgswiphak.ida.common.excel.style.config.ExcelCellStyleConfigurer

class DefaultHeaderCellStyle : CustomExcelCellStyle() {
    override fun configure(configurer: ExcelCellStyleConfigurer) {
        configurer.excelAlign(DefaultExcelAlign.align(ExcelStyle.CENTER_CENTER))
            .excelBorders(DefaultExcelBorders.newInstance(ExcelBorderStyle.THIN))
            .foregroundColor(217, 217, 217)
    }
}