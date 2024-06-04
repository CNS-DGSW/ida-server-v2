package com.dgswiphak.ida.common.model

@JvmInline
value class PhoneNumber(
    val value: String
) {
    init {
        if (value.isBlank()) throw IllegalArgumentException("Phone number must not be empty")
    }
}