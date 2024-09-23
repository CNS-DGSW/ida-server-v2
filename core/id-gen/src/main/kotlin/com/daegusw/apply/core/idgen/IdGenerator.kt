package com.daegusw.apply.core.idgen

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ThreadLocalRandom

object IdGenerator {
    fun generateUUIDWithLong(): Long {
        return ThreadLocalRandom.current().nextLong(900000) + 100000
    }

    fun generateUUIDWithString(): String {
        val currentDateTime = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyyMMddHH")
        val formattedDateTime = currentDateTime.format(formatter)

        return "$formattedDateTime-${generateUUIDWithLong()}"
    }
}