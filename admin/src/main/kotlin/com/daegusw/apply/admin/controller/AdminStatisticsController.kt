package com.daegusw.apply.admin.controller

import com.daegusw.apply.admin.dto.ApplicantGraduationTypeCompetitionRateResponse
import com.daegusw.apply.admin.dto.ApplicantSchoolCompetitionRateResponse
import com.daegusw.apply.admin.dto.UserSchoolCityInfoResponse
import com.daegusw.apply.admin.service.AdminStatisticsService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/statistics")
class AdminStatisticsController(
    private val adminStatisticsService: AdminStatisticsService
) {

    @GetMapping("/applicant")
    fun applyCompetitionRate(): List<com.daegusw.apply.admin.dto.ApplicantCompetitionRateResponse> {
        return adminStatisticsService.getApplicantCompetitionRate()
    }

    @GetMapping("/applicant/school")
    fun applicantSchoolCompetitionRate(): List<ApplicantSchoolCompetitionRateResponse> {
        return adminStatisticsService.getApplicantSchoolCompetitionRate()
    }

    @GetMapping("/applicant/graduation")
    fun applicantGraduationTypeCompetitionRate(): ApplicantGraduationTypeCompetitionRateResponse {
        return adminStatisticsService.getApplicantGraduationTypeCompetitionRate()
    }

    @GetMapping("/school")
    fun schoolOriginByRegion(): List<UserSchoolCityInfoResponse> {
        return adminStatisticsService.getSchoolOriginByRegion()
    }
}