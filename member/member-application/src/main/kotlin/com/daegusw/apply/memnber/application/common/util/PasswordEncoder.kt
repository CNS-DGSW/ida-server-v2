package com.daegusw.apply.memnber.application.common.util

import org.springframework.stereotype.Component
import java.security.MessageDigest

@Component
class PasswordEncoder {
    fun encode(rawString: String): String {
        val sb = StringBuilder()
        val md = MessageDigest.getInstance("SHA-512")
        md.update(rawString.encodeToByteArray())

        for (byteDatum in md.digest()) {
            sb.append(((byteDatum.toInt() and 0xff) + 0x100).toString(16).substring(1))
        }

        return sb.toString()
    }

    fun matches(rawString: String, encodedString: String): Boolean =
        encodedString == encode(rawString)
}