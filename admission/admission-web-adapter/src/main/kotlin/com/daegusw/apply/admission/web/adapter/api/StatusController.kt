package com.daegusw.apply.admission.web.adapter.api

import com.daegusw.apply.admission.application.port.`in`.web.StatusUseCase
import com.daegusw.apply.admission.web.adapter.api.response.StatusResponse
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admission/status")
class StatusController(
    private val statusUseCase: StatusUseCase
) {
    @GetMapping
    fun findStatus(
        @AuthenticatedPrincipalId id: MemberId
    ): StatusResponse {
        return StatusResponse(statusUseCase.find(id))
    }
}
