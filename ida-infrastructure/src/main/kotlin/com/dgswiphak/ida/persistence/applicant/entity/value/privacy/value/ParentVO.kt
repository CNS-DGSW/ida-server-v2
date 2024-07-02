package com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value

import com.dgswiphak.ida.common.model.PhoneNumber
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import java.time.LocalDate

@Embeddable
class ParentVO(
    @Column(name = "parent_name")
    val name: String,

    @Column(name = "parent_relation")
    val relation: String,

    @Column(name = "parent_phone")
    val phone: PhoneNumber,

    @Column(name = "parent_birth")
    val brith: LocalDate
)