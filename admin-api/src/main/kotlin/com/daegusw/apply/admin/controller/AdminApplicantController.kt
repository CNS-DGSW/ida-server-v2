package com.daegusw.apply.admin.controller

import com.daegusw.apply.admin.dto.ApplicantTableResponse
import com.daegusw.apply.admin.service.AdminApplicantService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/applicant")
class AdminApplicantController(
    private val adminApplicantService: AdminApplicantService
) {

    @GetMapping
    fun applicantTable(): List<ApplicantTableResponse> {
        return adminApplicantService.getApplicantTable()
    }

}