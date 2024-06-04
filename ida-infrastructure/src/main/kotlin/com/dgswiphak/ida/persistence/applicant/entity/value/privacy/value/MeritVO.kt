package com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class MeritVO(
    @Column(name = "merit_code")
    val code: String
)