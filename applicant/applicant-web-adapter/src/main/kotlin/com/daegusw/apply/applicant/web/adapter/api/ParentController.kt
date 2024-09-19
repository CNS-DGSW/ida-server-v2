package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.port.`in`.web.ParentUseCase
import com.daegusw.apply.applicant.web.adapter.api.request.ParentRequest
import com.daegusw.apply.applicant.web.adapter.api.response.ParentResponse
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
@RequestMapping("/applicant/parent")
class ParentController(
    private val parentUseCase: ParentUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findParent(
        @AuthenticatedPrincipalId id: MemberId
    ): ParentResponse {
        return ParentResponse(parentUseCase.find(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateParent(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: ParentRequest
    ) {
        parentUseCase.update(id, request.toParentDto())
    }
}