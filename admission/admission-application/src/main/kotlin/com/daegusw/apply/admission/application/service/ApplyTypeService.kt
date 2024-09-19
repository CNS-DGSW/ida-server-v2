package com.daegusw.apply.admission.application.service

import com.daegusw.apply.admission.application.common.exception.AdmissionDoesNotExistException
import com.daegusw.apply.admission.application.port.`in`.web.ApplyTypeUseCase
import com.daegusw.apply.admission.application.port.out.persistence.CommandAdmissionPort
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.daegusw.apply.admission.domain.admission.value.AdmissionApplicant
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service

@Service
class ApplyTypeService(
    private val queryAdmissionPort: QueryAdmissionPort,
    private val commandAdmissionPort: CommandAdmissionPort
) : ApplyTypeUseCase {
    override fun find(id: MemberId): ApplyType {
        val admission = queryAdmissionPort.findByMemberId(id) ?: throw AdmissionDoesNotExistException(id)

        return admission.applicant!!.type
    }

    override fun update(id: MemberId, type: ApplyType) {
        val admission = queryAdmissionPort.findByMemberId(id) ?: Admission()

        admission.updateType(AdmissionApplicant(id, type))

        commandAdmissionPort.save(admission)
    }
}