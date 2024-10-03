package com.daegusw.apply.admission.application.service

import com.daegusw.apply.admission.application.common.dto.StatusDto
import com.daegusw.apply.admission.application.common.exception.AdmissionDoesNotExistException
import com.daegusw.apply.admission.application.port.`in`.web.StatusUseCase
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StatusService (
    private val queryAdmissionPort: QueryAdmissionPort
) : StatusUseCase {
    @Transactional(readOnly = true)
    override fun find(id: MemberId): StatusDto {
        val admission = queryAdmissionPort.findByMemberId(id) ?: throw AdmissionDoesNotExistException(id)

        return StatusDto(admission.status!!)
    }
}