package com.daegusw.apply.admission.application.service

import com.daegusw.apply.admission.application.common.exception.AdmissionDoesNotExistException
import com.daegusw.apply.admission.application.port.`in`.web.ProgressUseCase
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProgressService (
    private val queryAdmissionPort: QueryAdmissionPort
) : ProgressUseCase{

    @Transactional(readOnly = true)
    override fun find(id: MemberId): Progress {
        val admission = queryAdmissionPort.findByMemberId(id) ?: throw AdmissionDoesNotExistException(id)

        return admission.progress

    }

}