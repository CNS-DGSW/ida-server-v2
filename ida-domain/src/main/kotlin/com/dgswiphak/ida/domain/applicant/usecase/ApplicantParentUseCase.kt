package com.dgswiphak.ida.domain.applicant.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.domain.Applicant
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.Privacy
import com.dgswiphak.ida.domain.applicant.dto.request.UpdateParentInfoRequest
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantParentInfoResponse
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi


@UseCase
class ApplicantParentUseCase(
    private val queryApplicantSpi: QueryApplicantSpi,
    private val commandApplicantSpi: CommandApplicantSpi
) {
    fun updateParentInfo(memberId: MemberId, parentRequest: UpdateParentInfoRequest) {
        val applicant = queryApplicantSpi.findById(memberId) ?: throw RuntimeException()
        applicant.updatePrivacy(
            updateParentAndAddress(
                applicant.privacy,
                parentRequest
            )
        )
        commandApplicantSpi.save(applicant)
    }

    fun findParentInfo(memberId: MemberId): ApplicantParentInfoResponse {
        val applicant: Applicant = queryApplicantSpi.findById(memberId) ?: throw RuntimeException()
        return ApplicantParentInfoResponse(
            applicant.privacy.parent,
            applicant.privacy.address
        )
    }

    private fun updateParentAndAddress(privacy: Privacy, request: UpdateParentInfoRequest): Privacy {
        privacy.updateAddress(request.toAddress())
        privacy.updateParentInfo(request.toParent())
        return privacy
    }
}