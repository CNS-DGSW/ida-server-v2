package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.port.`in`.web.InformationUseCase
import com.daegusw.apply.applicant.web.adapter.api.request.InformationRequest
import com.daegusw.apply.applicant.web.adapter.api.response.InformationResponse
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/applicant/information")
class InformationController(
    private val informationUseCase: InformationUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findInformation(
        @AuthenticatedPrincipalId id: MemberId
    ): InformationResponse {
        return InformationResponse(informationUseCase.find(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateInformation(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: InformationRequest
    ) {
        informationUseCase.update(id, request.toInformationDto())
    }
}