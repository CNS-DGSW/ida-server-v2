package com.daegusw.apply.core.excel.resource.sheet

import com.daegusw.apply.core.excel.SXSSFExcelFile
import com.daegusw.apply.core.excel.resource.DataFormatDecider

class OneSheetExcelFile<T : Any> : SXSSFExcelFile<T> {

    private var currentRowIndex = ROW_START_INDEX

    companion object {
        private const val ROW_START_INDEX = 0
        private const val COLUMN_START_INDEX = 0
    }

    constructor(type: Class<T>) : super(type)

    constructor(data: List<T>, type: Class<T>) : super(data, type)

    constructor(data: List<T>, type: Class<T>, dataFormatDecider: DataFormatDecider) : super(data, type, dataFormatDecider)

    override fun validateData(data: List<T>) {
        val maxRows = supplyExcelVersion.maxRows
        if (data.size > maxRows) {
            throw IllegalArgumentException("This concrete ExcelFile does not support over $maxRows rows")
        }
    }

    override fun renderExcel(data: List<T>) {
        sheet = workbook.createSheet()
        renderHeadersWithNewSheet(sheet!!, currentRowIndex++, COLUMN_START_INDEX)

        if (data.isEmpty()) {
            return
        }

        for (renderedData in data) {
            renderBody(renderedData, currentRowIndex++, COLUMN_START_INDEX)
        }
    }

    override fun addRows(data: List<T>) {
        for (renderedData in data) {
            renderBody(renderedData, currentRowIndex++, COLUMN_START_INDEX)
        }
    }
}
