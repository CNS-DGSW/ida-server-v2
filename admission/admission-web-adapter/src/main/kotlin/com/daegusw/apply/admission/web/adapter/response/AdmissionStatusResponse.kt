package com.daegusw.apply.admission.web.adapter.response

import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.daegusw.apply.admission.domain.admission.constant.FirstAdmissionStatus
import com.daegusw.apply.admission.domain.admission.constant.LastAdmissionStatus

data class AdmissionStatusResponse(
    val applyType: ApplyType,
    val admissionStatus: String
) {
    constructor(pair: Pair<FirstAdmissionStatus, ApplyType>) : this(
        applyType = pair.second,
        admissionStatus = pair.first.message
    )

    constructor(pair: Pair<LastAdmissionStatus, ApplyType>) : this(
        applyType = pair.second,
        admissionStatus = pair.first.message
    )
}