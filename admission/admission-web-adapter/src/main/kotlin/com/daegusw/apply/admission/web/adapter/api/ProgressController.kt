package com.daegusw.apply.admission.web.adapter.api

import com.daegusw.apply.admission.application.port.`in`.web.ProgressUseCase
import com.daegusw.apply.admission.web.adapter.api.response.ProgressResponse
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admission/progress")
class ProgressController (
    private val progressUseCase: ProgressUseCase
){
    @GetMapping
    fun findProgress(
        @AuthenticatedPrincipalId id: MemberId
    ): ProgressResponse {
        return ProgressResponse(progressUseCase.find(id))
    }
}