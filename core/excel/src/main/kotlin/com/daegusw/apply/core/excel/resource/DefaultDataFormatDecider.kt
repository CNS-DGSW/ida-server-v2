package com.daegusw.apply.core.excel.resource

import org.apache.poi.ss.usermodel.DataFormat

class DefaultDataFormatDecider : DataFormatDecider {

    override fun getDataFormat(dataFormat: DataFormat, type: Class<*>): Short {
        return when {
            isFloatType(type) -> dataFormat.getFormat(FLOAT_FORMAT_2_DECIMAL_PLACES)
            isIntegerType(type) -> dataFormat.getFormat(CURRENT_FORMAT)
            else -> dataFormat.getFormat(DEFAULT_FORMAT)
        }
    }

    private fun isFloatType(type: Class<*>): Boolean {
        val floatTypes = listOf(
            Float::class.java, java.lang.Float.TYPE,
            Double::class.java, java.lang.Double.TYPE
        )
        return floatTypes.contains(type)
    }

    private fun isIntegerType(type: Class<*>): Boolean {
        val integerTypes = listOf(
            Byte::class.java, java.lang.Byte.TYPE,
            Short::class.java, java.lang.Short.TYPE,
            Integer::class.java, Integer.TYPE,
            Long::class.java, java.lang.Long.TYPE
        )
        return integerTypes.contains(type)
    }

    companion object {
        private const val CURRENT_FORMAT = "#,##0"
        private const val FLOAT_FORMAT_2_DECIMAL_PLACES = "#,##0.00"
        private const val DEFAULT_FORMAT = ""
    }
}