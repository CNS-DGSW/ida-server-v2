package com.dgswiphak.ida.aggregate.admin

import com.dgswiphak.ida.domain.admin.dto.PassApplicantTableResponse
import com.dgswiphak.ida.domain.admin.usecase.AdminPassApplicantUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/pass-applicant")
class AdminPassApplicantController(
    val adminPassApplicantUseCase: AdminPassApplicantUseCase
) {

    @GetMapping("/table")
    fun passApplicantTable() : List<PassApplicantTableResponse> {
        return adminPassApplicantUseCase.getPassApplicantTable()
    }
}