package com.dgswiphak.ida.domain.applicant.model.value.privacy.value

data class Merit(
    val code: String
) {
    init {
        if (code.isNotBlank()) throw IllegalArgumentException("Merit code cannot be blank.")
    }
}