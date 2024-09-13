package com.daegusw.apply.core.data.entity.admission.value

import com.daegusw.apply.admission.domain.constant.ApplyType
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import javax.persistence.Embeddable
import javax.persistence.Embedded

@Embeddable
data class AdmissionApplicantVO(
    @Embedded
    val member: EmbeddedMemberId,
    var type: ApplyType = ApplyType.NONE
)
