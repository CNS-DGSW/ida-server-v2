package com.dgswiphak.ida.common.util

interface PasswordUtil {
    fun encoded(raw: String): String

    fun matches(raw: String, encoded: String): Boolean
}