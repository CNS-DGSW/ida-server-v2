package com.daegusw.apply.core.data.entity.admission.value

import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import javax.persistence.Embeddable

@Embeddable
data class AdmissionApplicantVO(
    val member: EmbeddedMemberId,
    val type: ApplyType
)