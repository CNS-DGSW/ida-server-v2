package com.dgswiphak.ida.aggregate.admin

import com.dgswiphak.ida.domain.admin.dto.ApplicantSchoolCompetitionRate
import com.dgswiphak.ida.domain.admin.dto.ApplicantCompetitionRate
import com.dgswiphak.ida.domain.admin.dto.ApplicantGraduationTypeCompetitionRate
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

    @GetMapping("/applicant")
    fun applyCompetitionRate(): List<ApplicantCompetitionRate> {
        return adminStatisticsUseCase.getApplicantCompetitionRate()
    }

    @GetMapping("/applicant/school")
    fun applicantSchoolCompetitionRate(): List<ApplicantSchoolCompetitionRate> {
        return adminStatisticsUseCase.getApplicantSchoolCompetitionRate()
    }

    @GetMapping("/applicant/graduation")
    fun applicantGraduationTypeCompetitionRate(): ApplicantGraduationTypeCompetitionRate {
        return adminStatisticsUseCase.getApplicantGraduationTypeCompetitionRate()
    }

    @GetMapping("/school")
    fun schoolOriginByRegion(): List<UserSchoolCityInfoResponse> {
        return adminStatisticsUseCase.getSchoolOriginByRegion()
    }
}