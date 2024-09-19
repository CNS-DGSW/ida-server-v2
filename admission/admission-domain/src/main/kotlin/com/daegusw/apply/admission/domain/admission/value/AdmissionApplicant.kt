package com.daegusw.apply.admission.domain.admission.value

import com.daegusw.apply.member.id.MemberId
import com.daegusw.apply.admission.domain.admission.constant.ApplyType

data class AdmissionApplicant(
    val member: MemberId,
    val type: ApplyType
)