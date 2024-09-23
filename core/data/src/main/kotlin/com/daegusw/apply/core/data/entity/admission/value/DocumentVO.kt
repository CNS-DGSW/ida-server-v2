package com.daegusw.apply.core.data.entity.admission.value

import javax.persistence.Embeddable

@Embeddable
data class DocumentVO(
    val introduce: String,
    val studyPlan: String
)