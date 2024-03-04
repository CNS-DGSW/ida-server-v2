package com.dgswiphak.ida.domain.applicant.domain.value.privacy.value

data class Photo(
    val filename: String
) {
    companion object {
        fun of(filename: String): Photo {
            return Photo(filename)
        }
    }
}