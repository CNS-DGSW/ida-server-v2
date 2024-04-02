package com.dgswiphak.ida.common.util

interface PasswordUtil {
    fun encoded(raw: CharSequence): String

    fun matches(raw: CharSequence, encoded: String): Boolean
}