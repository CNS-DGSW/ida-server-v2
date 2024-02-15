package com.dgswiphak.ida.aggregate.applicant

import com.dgswiphak.ida.domain.applicant.dto.request.UpdateApplicantInfoRequest
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantInfoResponse
import com.dgswiphak.ida.domain.applicant.usecase.ApplicantInfoUseCase
import com.dgswiphak.ida.global.auth.AuthDetails
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
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
        @AuthenticationPrincipal auth: AuthDetails,
        @RequestBody request: UpdateApplicantInfoRequest
    ) {
        applicantInfoUseCase.updateInformation(auth.getId(), request)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findInfo(
        @AuthenticationPrincipal auth: AuthDetails
    ) : ApplicantInfoResponse {
        return applicantInfoUseCase.findInformation(auth.getId())
    }

}