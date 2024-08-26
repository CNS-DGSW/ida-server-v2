package com.dgswiphak.ida.common.excel

import java.io.OutputStream

interface ExcelFile<T> {
    fun write(outputStream: OutputStream)

    fun addRows(data: List<T>)
}