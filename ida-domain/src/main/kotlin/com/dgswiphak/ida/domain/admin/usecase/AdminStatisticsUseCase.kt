package com.dgswiphak.ida.domain.admin.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.admin.dto.AdmissionCompetitionRateResponse
import com.dgswiphak.ida.domain.admin.dto.UserSchoolCityInfoResponse
import com.dgswiphak.ida.domain.applicant.domain.value.education.value.type.GraduationType.*
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.type.Gender.FEMALE
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.type.Gender.MALE
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi

@UseCase
class AdminStatisticsUseCase(
    private val queryApplicantSpi: QueryApplicantSpi
) {

    fun getApplicantCompetitionRate(): AdmissionCompetitionRateResponse {
        val applicants = queryApplicantSpi.findAll()
        val info = AdmissionCompetitionRateResponse()
        applicants.map {
            if (it.education.graduationType != null) {
                when (it.privacy.gender!!) {
                    MALE -> {
                        when (it.education.graduationType!!) {
                            EXPECTED -> info.expectedMale
                            GRADUATED -> info.graduatedMale
                            GED -> info.gedMale
                        }
                    }

                    FEMALE -> {
                        when (it.education.graduationType!!) {
                            EXPECTED -> info.expectedFemale
                            GRADUATED -> info.graduatedFemale
                            GED -> info.gedFemale
                        }
                    }
                }
            }
        }
        info.male = info.graduatedMale + info.expectedMale + info.gedMale
        info.female = info.graduatedFemale + info.expectedFemale + info.gedFemale
        info.total = info.male + info.female

        return info
    }

    fun getSchoolOriginByRegion(): List<UserSchoolCityInfoResponse> {
        val applicants = queryApplicantSpi.findAll()
        val userSchoolCityInfoList: MutableList<UserSchoolCityInfoResponse> = mutableListOf()
        var index: Long = 1
        applicants.map { applicant ->
            val school = applicant.education.school
            if (school != null && applicant.education.graduationType != GED) {
                var info: UserSchoolCityInfoResponse? = userSchoolCityInfoList.find {
                    it.city == school.city && it.schoolName == school.name
                }
                if (info == null) {
                    info = UserSchoolCityInfoResponse(
                        index = index++,
                        city = school.city,
                        schoolName = school.name
                    )
                    userSchoolCityInfoList.add(info)
                }
                when (applicant.privacy.gender!!) {
                    MALE -> {
                        if (applicant.education.graduationType == GRADUATED) info.graduatedMale++
                        else info.expectedMale++
                    }

                    FEMALE -> {
                        if (applicant.education.graduationType == GRADUATED) info.graduatedFemale++
                        else info.expectedFemale++
                    }
                }
            }
        }
        userSchoolCityInfoList.sortBy { it.index }
        return userSchoolCityInfoList
    }
}