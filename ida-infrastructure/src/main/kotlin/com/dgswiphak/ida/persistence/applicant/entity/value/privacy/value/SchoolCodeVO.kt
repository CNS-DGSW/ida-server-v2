package com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class SchoolCodeVO(
    @Column(name = "school_code")
    val value: String
)