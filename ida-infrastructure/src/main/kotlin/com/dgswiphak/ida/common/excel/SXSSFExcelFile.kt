package com.dgswiphak.ida.common.excel

import com.dgswiphak.ida.common.excel.resource.*
import com.dgswiphak.ida.common.excel.utils.SuperClassReflectionUtils.getField
import org.apache.poi.ss.SpreadsheetVersion
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.streaming.SXSSFWorkbook
import java.io.IOException
import java.io.OutputStream
import java.lang.RuntimeException
import java.lang.reflect.Field
import java.util.*


abstract class SXSSFExcelFile<T>(
    type: Class<T>
) : ExcelFile<T> {

    protected val supplyExcelVersion: SpreadsheetVersion = SpreadsheetVersion.EXCEL2007
    protected var workbook: SXSSFWorkbook = SXSSFWorkbook()
    protected var sheet: Sheet? = null
    private var renderResource: ExcelRenderResource = ExcelRenderResourceFactory().prepareRenderResource(type, workbook, DefaultDataFormatDecider())

    constructor(data: List<T>, type: Class<T>) : this(data, type, DefaultDataFormatDecider())


    constructor(data: List<T>, type: Class<T>, dataFormatDecider: DataFormatDecider) : this(type) {
        validateData(data)
        renderResource = ExcelRenderResourceFactory().prepareRenderResource(type, workbook, dataFormatDecider)
        renderExcel(data)
    }

    protected open fun validateData(data: List<T>) { }

    protected abstract fun renderExcel(data: List<T>)

    protected fun renderHeadersWithNewSheet(sheet: Sheet, rowIndex: Int, columnStartIndex: Int) {
        val row: Row = sheet.createRow(rowIndex)
        var columnIndex = columnStartIndex
        for (dataFieldName in renderResource.getDataFieldNames()) {
            sheet.setColumnWidth(columnIndex, renderResource.getSellWidth())
            val cell: Cell = row.createCell(columnIndex++)
            cell.cellStyle = renderResource.getCellStyle(dataFieldName, ExcelRenderLocation.HEADER)
            cell.setCellValue(renderResource.getExcelHeaderName(dataFieldName))
        }
    }

    protected fun renderBody(data: Any, rowIndex: Int, columnStartIndex: Int) {
        val row: Row = sheet!!.createRow(rowIndex)
        var columnIndex = columnStartIndex
        for (dataFieldName in renderResource.getDataFieldNames()) {
            val cell: Cell = row.createCell(columnIndex++)
            try {
                val field: Field = getField(data.javaClass, dataFieldName)
                field.isAccessible = true
                cell.cellStyle = renderResource.getCellStyle(dataFieldName, ExcelRenderLocation.BODY)
                val cellValue: Any? = field.get(data)
                renderCellValue(cell, cellValue)
            } catch (e: Exception) {
                throw RuntimeException(e.message, e)
            }
        }
    }

    private fun renderCellValue(cell: Cell, cellValue: Any?) {
        if (cellValue is Number) {
            cell.setCellValue(cellValue.toDouble())
            return
        }
        cell.setCellValue(cellValue?.toString() ?: "")
    }

    @Throws(IOException::class)
    override fun write(outputStream: OutputStream) {
        workbook.write(outputStream)
        workbook.close()
        workbook.dispose()
        outputStream.close()
    }
}