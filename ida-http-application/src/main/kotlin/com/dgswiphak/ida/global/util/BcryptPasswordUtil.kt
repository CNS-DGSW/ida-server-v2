package com.dgswiphak.ida.global.util

import com.dgswiphak.ida.common.util.PasswordUtil
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class BcryptPasswordUtil : PasswordUtil {
    private val passwordEncoder: PasswordEncoder = BCryptPasswordEncoder()

    override fun encoded(raw: String): String {
        return passwordEncoder.encode(raw)
    }

    override fun matches(raw: String, encoded: String): Boolean {
        return passwordEncoder.matches(raw, encoded)
    }

}