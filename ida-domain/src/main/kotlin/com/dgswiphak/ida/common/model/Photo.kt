package com.dgswiphak.ida.common.model

@JvmInline
value class Photo(
    val value: String
) {
    init {
        if (value.isBlank()) throw IllegalArgumentException()
    }
}