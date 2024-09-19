package com.daegusw.apply.core.data.entity.applicant.value

import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class ParentVO(
    @Column(name = "parent_name")
    val name: String,

    @Column(name = "parent_relation")
    val relation: String,

    @Column(name = "parent_phone")
    val phone: String,

    @Column(name = "parent_birth")
    val birth: LocalDate
)