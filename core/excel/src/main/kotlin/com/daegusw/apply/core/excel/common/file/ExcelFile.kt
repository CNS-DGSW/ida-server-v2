package com.daegusw.apply.core.excel.common.file

import java.io.OutputStream

interface ExcelFile<T> {
    fun write(outputStream: OutputStream)

    fun addRows(data: List<T>)
}