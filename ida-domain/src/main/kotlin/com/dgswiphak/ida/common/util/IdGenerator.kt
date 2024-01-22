package com.dgswiphak.ida.common.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.ThreadLocalRandom

class IdGenerator {

    companion object {

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
}