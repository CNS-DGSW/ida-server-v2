package com.daegusw.apply.core.excel.style

import com.daegusw.apply.core.excel.common.file.ExcelCellStyle
import com.daegusw.apply.core.excel.style.config.ExcelCellStyleConfigurer
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
