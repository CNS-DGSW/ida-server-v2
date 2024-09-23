package com.daegusw.apply.admission.application.port.`in`.web

import com.daegusw.apply.admission.domain.admission.constant.FirstAdmissionStatus
import com.daegusw.apply.admission.domain.admission.constant.LastAdmissionStatus
import com.daegusw.apply.member.id.MemberId


interface AdmissionStatusUseCase {
    fun findFirstStatus(id: MemberId): FirstAdmissionStatus
    fun findLastStatus(id: MemberId): LastAdmissionStatus
}