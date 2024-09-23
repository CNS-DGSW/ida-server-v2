package com.daegusw.apply.admission.web.adapter

import com.daegusw.apply.admission.application.port.`in`.web.ApplyTypeUseCase
import com.daegusw.apply.admission.web.adapter.request.ApplyTypeRequest
import com.daegusw.apply.admission.web.adapter.response.ApplyTypeResponse
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
@RequestMapping("/admission/type")
class ApplyTypeController(
    private val applyTypeUseCase: ApplyTypeUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findApplyType(
        @AuthenticatedPrincipalId id: MemberId
    ): ApplyTypeResponse {
        return ApplyTypeResponse(applyTypeUseCase.find(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateApplyType(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: ApplyTypeRequest
    ) {
        applyTypeUseCase.update(id, request.type)
    }
}