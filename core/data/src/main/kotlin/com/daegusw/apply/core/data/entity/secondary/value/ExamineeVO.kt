package com.daegusw.apply.core.data.entity.secondary.value

import com.daegusw.apply.core.data.entity.admission.AdmissionEntity
import javax.persistence.Embeddable
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Embeddable
data class ExamineeVO(
    @OneToOne @JoinColumn(name = "admission_id")
    val admission: AdmissionEntity,

    val examCode: Long
)