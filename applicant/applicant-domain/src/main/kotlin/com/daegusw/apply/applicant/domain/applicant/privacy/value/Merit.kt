package com.daegusw.apply.applicant.domain.applicant.privacy.value

data class Merit(
    val code: String
) {
    init {
        if (code.isBlank()) throw IllegalArgumentException("Merit code cannot be blank.")
    }
}