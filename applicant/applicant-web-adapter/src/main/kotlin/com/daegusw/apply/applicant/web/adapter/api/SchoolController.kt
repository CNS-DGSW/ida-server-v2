package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.common.dto.SchoolResponse
import com.daegusw.apply.applicant.application.port.`in`.web.SchoolUseCase
import com.daegusw.apply.applicant.web.adapter.api.request.SchoolRequest
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/applicant/school")
class SchoolController(
    private val schoolUseCase: SchoolUseCase
) {
    @GetMapping
    fun findSchool(
        @AuthenticatedPrincipalId id: MemberId
    ) {
        schoolUseCase.find(id)
    }

    @PutMapping
    fun updateSchool(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: SchoolRequest
    ) {
        schoolUseCase.update(id, request.toDto())
    }

    @GetMapping("/search")
    fun schoolSearch(
        @RequestParam q: String
    ): List<SchoolResponse> {
        return schoolUseCase.search(q)
    }
}