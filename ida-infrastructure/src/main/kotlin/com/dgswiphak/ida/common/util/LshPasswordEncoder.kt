package com.dgswiphak.ida.common.util

import kr.re.nsr.crypto.Hash
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.util.*

@Component
class LshPasswordEncoder : PasswordUtil {
    private val algorithm: Hash.Algorithm = Hash.Algorithm.LSH512_512
    override fun encoded(raw: CharSequence): String {
        return hashString(raw.toString(), generateRandomString(10))
    }

    override fun matches(raw: CharSequence, encoded: String): Boolean {
        val tokens = encoded.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()
        val salt = tokens[0]
        val requested = hashString(raw.toString(), salt)
        return encoded == requested
    }

    private fun hashString(data: String, salt: String): String {
        val engine: Hash = Hash.getInstance(algorithm)
        engine.update(data.toByteArray(StandardCharsets.UTF_8))
        engine.update(salt.toByteArray(StandardCharsets.UTF_8))
        val hashBytes: ByteArray = engine.doFinal()
        return String.format("%s.%s", salt, Base64.getEncoder().encodeToString(hashBytes))
    }

    private val SOURCES = CharRange('A', 'Z').toList()

    private fun generateRandomString(length: Int): String {
        val sb = StringBuilder()
        for (i in 0 until length) {
            sb.append(SOURCES[(Math.random() * SOURCES.size).toInt()])
        }
        return sb.toString()
    }
}