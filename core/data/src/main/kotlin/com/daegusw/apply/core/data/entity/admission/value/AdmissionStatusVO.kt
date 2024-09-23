package com.daegusw.apply.core.data.entity.admission.value

import com.daegusw.apply.admission.domain.admission.constant.FirstAdmissionStatus
import com.daegusw.apply.admission.domain.admission.constant.LastAdmissionStatus
import javax.persistence.Embeddable

@Embeddable
data class AdmissionStatusVO(
    val firstAdmissionStatus: FirstAdmissionStatus = FirstAdmissionStatus.NONE,
    val lastAdmissionStatus: LastAdmissionStatus = LastAdmissionStatus.NONE
)
