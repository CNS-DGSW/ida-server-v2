package com.daegusw.apply.admission.web.adapter.api.response

import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.daegusw.apply.admission.domain.admission.constant.FirstAdmissionStatus
import com.daegusw.apply.admission.domain.admission.constant.LastAdmissionStatus

data class AdmissionStatusResponse(
    val applyType: ApplyType,
    val admissionStatus: String
) {
    companion object {
        fun fromFirst(pair: Pair<FirstAdmissionStatus, ApplyType>): AdmissionStatusResponse {
            return AdmissionStatusResponse(
                applyType = pair.second,
                admissionStatus = pair.first.message
            )
        }

        fun fromLast(pair: Pair<LastAdmissionStatus, ApplyType>): AdmissionStatusResponse {
            return AdmissionStatusResponse(
                applyType = pair.second,
                admissionStatus = pair.first.message
            )
        }
    }
}
