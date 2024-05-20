package com.dgswiphak.ida.aggregate.admin

import com.dgswiphak.ida.domain.admin.dto.AdmissionCompetitionRateResponse
import com.dgswiphak.ida.domain.admin.dto.UserSchoolCityInfoResponse
import com.dgswiphak.ida.domain.admin.usecase.AdminStatisticsUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/statistics")
class AdminStatisticsController(
    private val adminStatisticsUseCase: AdminStatisticsUseCase
) {

    @GetMapping("/school")
    fun getSchoolOriginByRegion(): List<UserSchoolCityInfoResponse> {
        return adminStatisticsUseCase.getSchoolOriginByRegion()
    }

    @GetMapping("/applicant")
    fun getApplicantCompetitionRate(): AdmissionCompetitionRateResponse {
        return adminStatisticsUseCase.getApplicantCompetitionRate()
    }
}