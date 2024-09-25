package com.daegusw.apply.core.excel.style

import com.daegusw.apply.core.excel.style.align.DefaultExcelAlign
import com.daegusw.apply.core.excel.style.align.ExcelStyle
import com.daegusw.apply.core.excel.style.border.DefaultExcelBorders
import com.daegusw.apply.core.excel.style.border.ExcelBorderStyle
import com.daegusw.apply.core.excel.style.config.ExcelCellStyleConfigurer

class DefaultBodyCellStyle : CustomExcelCellStyle() {
    override fun configure(configurer: ExcelCellStyleConfigurer) {
        configurer.foregroundColor(255, 255, 255)
            .excelAlign(DefaultExcelAlign.align(ExcelStyle.CENTER_CENTER))
            .excelBorders(DefaultExcelBorders.newInstance(ExcelBorderStyle.THIN))
    }
}