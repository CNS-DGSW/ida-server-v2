package com.dgswiphak.ida.aggregate.applicant

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.dto.request.UpdateApplicantInfoRequest
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantInfoResponse
import com.dgswiphak.ida.domain.applicant.usecase.ApplicantInfoUseCase
import com.dgswiphak.ida.global.auth.annotation.AuthenticatedPrincipalId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/applicant/info")
class ApplicantInfoController(
    private val applicantInfoUseCase: ApplicantInfoUseCase
) {
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateInfo(
        @AuthenticatedPrincipalId memberId: MemberId,
        @RequestBody request: UpdateApplicantInfoRequest
    ) {
        applicantInfoUseCase.updateInformation(memberId, request)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findInfo(
        @AuthenticatedPrincipalId memberId: MemberId,
    ) : ApplicantInfoResponse {
        return applicantInfoUseCase.findInformation(memberId)
    }

}