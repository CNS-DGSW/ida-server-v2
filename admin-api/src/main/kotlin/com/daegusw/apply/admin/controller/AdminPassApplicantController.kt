package com.daegusw.apply.admin.controller

import com.daegusw.apply.admin.dto.PassApplicantTableResponse
import com.daegusw.apply.admin.service.AdminPassApplicantService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/pass-applicant")
class AdminPassApplicantController(
    private val adminPassApplicantService: AdminPassApplicantService
) {

    @GetMapping
    fun passApplicantTable(): List<PassApplicantTableResponse> {
        return adminPassApplicantService.getPassApplicantTable()
    }
}