package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.common.dto.SchoolResponse
import com.daegusw.apply.applicant.application.port.`in`.web.SchoolUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/school")
class SchoolController(
    private val schoolUseCase: SchoolUseCase
) {
    @GetMapping("/search")
    fun schoolSearch(
        @RequestParam q: String
    ): List<SchoolResponse> {
        return schoolUseCase.search(q)
    }
}