package com.dgswiphak.ida.aggregate.applicant

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.dto.request.UpdateApplicantEducationRequest
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantEducationResponse
import com.dgswiphak.ida.domain.applicant.usecase.ApplicantEducationUseCase
import com.dgswiphak.ida.global.auth.annotation.AuthenticatedPrincipalId
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/applicant/education")
class ApplicantEducationController(
    private val applicantEducationUseCase: ApplicantEducationUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findEducation(
        @AuthenticatedPrincipalId id: MemberId
    ): ApplicantEducationResponse {
        return applicantEducationUseCase.findEducation(id)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateEducation(
        @AuthenticatedPrincipalId id: MemberId,
        @Valid @RequestBody request: UpdateApplicantEducationRequest
    ) {
        return applicantEducationUseCase.updateEducation(id, request)
    }
}