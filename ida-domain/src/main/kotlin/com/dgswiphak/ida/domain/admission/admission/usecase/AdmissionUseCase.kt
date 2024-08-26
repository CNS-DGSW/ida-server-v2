package com.dgswiphak.ida.domain.admission.admission.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.admission.admission.dto.ApplyTypeRequest
import com.dgswiphak.ida.domain.admission.admission.dto.ApplyTypeResponse
import com.dgswiphak.ida.domain.admission.admission.dto.DocumentDto
import com.dgswiphak.ida.domain.admission.admission.exception.NotFoundAdmissionException
import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.admission.admission.model.value.AdmissionApplicant
import com.dgswiphak.ida.domain.admission.admission.model.value.Document
import com.dgswiphak.ida.domain.admission.admission.model.value.type.ApplyType
import com.dgswiphak.ida.domain.admission.admission.spi.CommandAdmissionSpi
import com.dgswiphak.ida.domain.admission.admission.spi.QueryAdmissionSpi

@UseCase
class AdmissionUseCase(
    private val queryAdmissionSpi: QueryAdmissionSpi,
    private val commandAdmissionSpi: CommandAdmissionSpi
) {
    /**
     * 2023년도 기준, 전형 선택을 이후 점수 계산 등을 처리하므로
     * 전형 선택과 동시에 입학원서 엔티티를 등록합니다.
     */
    fun updateType(
        memberId: MemberId,
        request: ApplyTypeRequest
    ) {
        val admission = queryAdmissionSpi.findById(memberId.value) ?: Admission()

        admission.updateType(AdmissionApplicant(memberId, request.type))

        commandAdmissionSpi.save(admission)
    }

    fun findType(
        memberId: MemberId
    ): ApplyTypeResponse {
        val admission: Admission = queryAdmissionSpi.findById(memberId.value) ?: throw NotFoundAdmissionException
        return ApplyTypeResponse(
            type = admission.applicant?.applyType ?: ApplyType.NONE,
            mainCategory = admission.applicant?.applyType?.mainCategory,
            subCategory = admission.applicant?.applyType?.subCategory
        )
    }

    fun updateDocument(
        memberId: MemberId,
        documentDto: DocumentDto
    ) {
        val admission: Admission = queryAdmissionSpi.findById(memberId.value)?: throw NotFoundAdmissionException
        admission.updateDocument(Document(documentDto.introduce, documentDto.studyPlan))
    }

    fun findDocument(
        memberId: MemberId,
    ): DocumentDto {
        val admission: Admission = queryAdmissionSpi.findById(memberId.value)?: throw NotFoundAdmissionException
        return DocumentDto(
            introduce = admission.document?.introduce ?: "",
            studyPlan = admission.document?.studyPlane ?: ""
        )
    }
}
