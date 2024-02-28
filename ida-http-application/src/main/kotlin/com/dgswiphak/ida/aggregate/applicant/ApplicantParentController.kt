package com.dgswiphak.ida.aggregate.applicant

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.dto.request.UpdateParentInfoRequest
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantParentInfoResponse
import com.dgswiphak.ida.domain.applicant.usecase.ApplicantParentUseCase
import com.dgswiphak.ida.global.auth.annotation.AuthenticatedPrincipalId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/applicant/parent")
class ApplicantParentController(
    private val applicantParentUseCase: ApplicantParentUseCase
) {
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateParentInfo(
        @AuthenticatedPrincipalId memberId: MemberId,
        @RequestBody request: UpdateParentInfoRequest
    ) {
        applicantParentUseCase.updateParentInfo(memberId, request)
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findParentInfo(
        @AuthenticatedPrincipalId memberId: MemberId
    ): ApplicantParentInfoResponse {
        return applicantParentUseCase.findParentInfo(memberId)
    }
}