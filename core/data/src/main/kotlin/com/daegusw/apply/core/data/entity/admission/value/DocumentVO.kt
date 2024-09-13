package com.dgswiphak.ida.persistence.admission.admission.entity.value

import javax.persistence.Embeddable

@Embeddable
data class DocumentVO(
    val introduce: String,
    val studyPlane: String
)
