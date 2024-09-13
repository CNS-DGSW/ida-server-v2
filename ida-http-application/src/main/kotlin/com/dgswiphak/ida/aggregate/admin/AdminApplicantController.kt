package com.dgswiphak.ida.aggregate.admin

import com.dgswiphak.ida.domain.admin.dto.ApplicantTableResponse
import com.dgswiphak.ida.domain.admin.usecase.AdminApplicantUseCase
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/applicant")
class AdminApplicantController(
    private val adminApplicantUseCase: AdminApplicantUseCase
) {

    @GetMapping
    fun applicantTable() : List<ApplicantTableResponse> {
        return adminApplicantUseCase.getApplicantTable()
    }
}