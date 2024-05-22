package com.dgswiphak.ida.common.model

@JvmInline
value class SchoolCode(
    val value: String
) {
    init {
        if (value.isBlank()) throw IllegalArgumentException("SchoolCode value cannot be blank.")
    }
}