package com.dgswiphak.ida.domain.applicant.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.Privacy
import com.dgswiphak.ida.domain.applicant.dto.request.UpdateApplicantInfoRequest
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantInfoResponse
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi

@UseCase
class ApplicantInfoUseCase(
    private val commandApplicantSpi: CommandApplicantSpi,
    private val queryApplicantSpi: QueryApplicantSpi
) {
    fun updateInformation(id: MemberId, request: UpdateApplicantInfoRequest) {
        val applicant = queryApplicantSpi.findById(id) ?: throw RuntimeException()
        applicant.updatePrivacy(
            Privacy(
                name = request.name,
                birth = request.birth,
                phone = PhoneNumber.of(request.phoneNumber),
                gender = request.gender
            )
        )
        commandApplicantSpi.save(applicant)
    }

    fun findInformation(id: MemberId) : ApplicantInfoResponse{
        val applicant = queryApplicantSpi.findById(id) ?: throw RuntimeException()
        return ApplicantInfoResponse(applicant.privacy)
    }
}