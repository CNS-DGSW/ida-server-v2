package com.daegusw.apply.admission.web.adapter.api

import com.daegusw.apply.admission.application.port.`in`.web.AdmissionStatusUseCase
import com.daegusw.apply.admission.web.adapter.api.response.AdmissionStatusResponse
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admission/status")
class AdmissionStatusController (
    private val admissionStatusUseCase: AdmissionStatusUseCase
){

    @GetMapping("/first")
    @ResponseStatus(HttpStatus.OK)
    fun findFirstAdmissionStatus(
        @AuthenticatedPrincipalId id: MemberId
    ): AdmissionStatusResponse {
        return AdmissionStatusResponse.fromFirst(admissionStatusUseCase.findFirstStatus(id))
    }


    @GetMapping("/last")
    @ResponseStatus(HttpStatus.OK)
    fun findLastAdmissionStatus(
        @AuthenticatedPrincipalId id: MemberId
    ): AdmissionStatusResponse {
        return AdmissionStatusResponse.fromLast(admissionStatusUseCase.findLastStatus(id))
    }

}