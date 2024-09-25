package com.daegusw.apply.core.excel.resource

import org.apache.poi.ss.usermodel.DataFormat

interface DataFormatDecider {

    fun getDataFormat(dataFormat: DataFormat, type: Class<*>): Short
}