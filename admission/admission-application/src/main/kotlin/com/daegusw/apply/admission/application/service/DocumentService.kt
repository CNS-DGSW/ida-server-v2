package com.daegusw.apply.admission.application.service

import com.daegusw.apply.admission.application.common.dto.DocumentDto
import com.daegusw.apply.admission.application.common.exception.AdmissionDoesNotExistException
import com.daegusw.apply.admission.application.port.`in`.web.DocumentUseCase
import com.daegusw.apply.admission.application.port.out.persistence.CommandAdmissionPort
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class DocumentService(
    private val queryAdmissionPort: QueryAdmissionPort,
    private val commandAdmissionPort: CommandAdmissionPort
) : DocumentUseCase {
    @Transactional(readOnly = true)
    override fun find(id: MemberId): DocumentDto {
        val admission = queryAdmissionPort.findByMemberId(id) ?: throw AdmissionDoesNotExistException(id)

        return DocumentDto(admission.document)
    }

    @Transactional
    override fun update(id: MemberId, documentDto: DocumentDto) {
        val admission: Admission = queryAdmissionPort.findByMemberId(id) ?: throw AdmissionDoesNotExistException(id)

        admission.updateDocument(documentDto.toDocument())

        commandAdmissionPort.save(admission)
    }
}