package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.port.`in`.web.EducationUseCase
import com.daegusw.apply.applicant.web.adapter.api.request.EducationRequest
import com.daegusw.apply.applicant.web.adapter.api.response.EducationResponse
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/applicant/education")
class EducationController(
    private val educationUseCase: EducationUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findEducation(
        @AuthenticatedPrincipalId id: MemberId
    ): EducationResponse {
        return EducationResponse(educationUseCase.find(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateInformation(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: EducationRequest
    ) {
        educationUseCase.update(id, request.toEducationDto())
    }
}