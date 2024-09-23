package com.daegusw.apply.admission.application.service

import com.daegusw.apply.admission.application.common.exception.AdmissionDoesNotExistException
import com.daegusw.apply.admission.application.port.`in`.web.AdmissionStatusUseCase
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.constant.FirstAdmissionStatus
import com.daegusw.apply.admission.domain.admission.constant.LastAdmissionStatus
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdmissionStatusService (
    private val queryAdmissionPort: QueryAdmissionPort
) : AdmissionStatusUseCase {

    @Transactional(readOnly = true)
    override fun findFirstStatus(id: MemberId): FirstAdmissionStatus {

        val admission = queryAdmissionPort.findByMemberId(id) ?: throw AdmissionDoesNotExistException(id)

        return admission.admissionStatus?.firstAdmissionStatus?:FirstAdmissionStatus.NONE

    }

    @Transactional(readOnly = true)
    override fun findLastStatus(id: MemberId): LastAdmissionStatus {

        val admission = queryAdmissionPort.findByMemberId(id) ?: throw AdmissionDoesNotExistException(id)

        return admission.admissionStatus?.lastAdmissionStatus?:LastAdmissionStatus.NONE

    }
}