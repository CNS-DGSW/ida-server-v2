package com.dgswiphak.ida.persistence.admission.admission.entity.value

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.domain.admission.admission.model.value.type.ApplyType
import jakarta.persistence.*

@Embeddable
data class AdmissionApplicantVO(
    @Embedded
    val memberId: EmbeddedMemberId,
    var applyType: ApplyType = ApplyType.NONE
)
