package com.daegusw.apply.admission.domain.admission.value

import com.daegusw.apply.admission.domain.admission.constant.LastAdmissionStatus
import com.daegusw.apply.admission.domain.admission.constant.FirstAdmissionStatus

data class AdmissionStatus(
    val firstAdmissionStatus: FirstAdmissionStatus = FirstAdmissionStatus.NONE,
    val lastAdmissionStatus: LastAdmissionStatus = LastAdmissionStatus.NONE
)
