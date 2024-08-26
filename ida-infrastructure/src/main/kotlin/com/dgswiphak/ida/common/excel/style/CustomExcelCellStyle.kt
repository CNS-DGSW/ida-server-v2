package com.dgswiphak.ida.common.excel.style

import com.dgswiphak.ida.common.excel.ExcelCellStyle
import com.dgswiphak.ida.common.excel.style.config.ExcelCellStyleConfigurer
import org.apache.poi.ss.usermodel.CellStyle

abstract class CustomExcelCellStyle : ExcelCellStyle {

    private val configurer = ExcelCellStyleConfigurer()

    init {
        configure(configurer)
    }

    abstract fun configure(configurer: ExcelCellStyleConfigurer)

    override fun apply(cellStyle: Any) {
        configurer.configure(cellStyle as CellStyle)
    }
}
