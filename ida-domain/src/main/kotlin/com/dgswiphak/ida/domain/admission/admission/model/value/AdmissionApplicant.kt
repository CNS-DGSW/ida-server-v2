package com.dgswiphak.ida.domain.admission.admission.model.value

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.admission.admission.model.value.type.ApplyType

data class AdmissionApplicant(
    val memberId: MemberId,
    var applyType: ApplyType = ApplyType.NONE
)