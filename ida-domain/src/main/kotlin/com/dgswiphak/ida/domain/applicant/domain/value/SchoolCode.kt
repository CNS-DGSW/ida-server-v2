package com.dgswiphak.ida.domain.applicant.domain.value

data class SchoolCode(
    val code: String?
) {
    companion object {
        fun of(code: String?) : SchoolCode {
            return SchoolCode(code)
        }
    }
}
