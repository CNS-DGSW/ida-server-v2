package com.dgswiphak.ida.domain.admin.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.admin.dto.AdmissionsSchoolCompetitionRate
import com.dgswiphak.ida.domain.admin.dto.ApplyCompetitionRate
import com.dgswiphak.ida.domain.admin.dto.TotalAdmissionCompetitionRateResponse
import com.dgswiphak.ida.domain.admin.dto.UserSchoolCityInfoResponse
import com.dgswiphak.ida.domain.admission.admission.model.value.type.ApplyType
import com.dgswiphak.ida.domain.admission.admission.model.value.type.Progress
import com.dgswiphak.ida.domain.admission.admission.spi.QueryAdmissionSpi
import com.dgswiphak.ida.domain.applicant.model.Applicant
import com.dgswiphak.ida.domain.applicant.model.value.education.value.type.GraduationType.*
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender.FEMALE
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender.MALE
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi
import kotlin.math.round

@UseCase
class AdminStatisticsUseCase(
    private val queryApplicantSpi: QueryApplicantSpi,
    private val queryAdmissionSpi: QueryAdmissionSpi
) {

    fun getApplyCompetitionRate(): List<ApplyCompetitionRate> {
        val admission = queryAdmissionSpi.findAllByProgress(Progress.APPLY)
        val rateList: MutableList<ApplyCompetitionRate> = mutableListOf(
            ApplyCompetitionRate("일반전형"),
            ApplyCompetitionRate("특별전형(사회통합)"),
            ApplyCompetitionRate("특별전형(마이스터인재)"),
            ApplyCompetitionRate("특별전형(지역우선)"),
            ApplyCompetitionRate("특례입학")
        )

        admission.map {
            var rate: ApplyCompetitionRate? = rateList.find { item ->
                item.applyType == applyDetail(it.applicant!!.applyType)
            }
            val applicantInfo: Applicant? = queryApplicantSpi.findById(it.applicant!!.memberId)

            if (rate == null) rate = ApplyCompetitionRate(applyDetail(it.applicant!!.applyType))

            if (applicantInfo!!.privacy.gender == MALE) {
                if (applicantInfo.privacy.address!!.streetAddress.contains("대구광역시")) rate.daeguMen++
                else rate.otherMen++
            } else {
                if (applicantInfo.privacy.address!!.streetAddress.contains("대구광역시")) rate.daeguWomen++
                else rate.otherWomen++
            }
        }

        rateList.forEach {
            it.total = it.daeguMen + it.daeguWomen + it.otherMen + it.otherWomen
            it.rate = round((it.total / (if (it.personnel == 0) 1.0 else it.personnel.toDouble())) * 100) / 100.0
        }

        return rateList
    }

    fun getAdmissionsSchoolCompetitionRate(): List<AdmissionsSchoolCompetitionRate> {
        val applicants = queryApplicantSpi.findAll()
        val rateList: MutableList<AdmissionsSchoolCompetitionRate> = mutableListOf(
            AdmissionsSchoolCompetitionRate("일반전형"),
            AdmissionsSchoolCompetitionRate("특별전형(사회통합)"),
            AdmissionsSchoolCompetitionRate("특별전형(마이스터인재)"),
            AdmissionsSchoolCompetitionRate("특별전형(지역우선)"),
            AdmissionsSchoolCompetitionRate("특례입학")
        )

        applicants.forEach { applicant ->
            val admission = queryAdmissionSpi.findByMemberId(applicant.id.value)
            val rate: AdmissionsSchoolCompetitionRate? = rateList.find { item ->
                item.apply == applyDetail(admission!!.applicant!!.applyType)
            }

            rate?.let {
                val isMale = applicant.privacy.gender == MALE
                val isFromDaegu = applicant.education.school!!.city == "대구광역시"
                val graduationType = applicant.education.graduationType

                when {
                    isMale && isFromDaegu -> {
                        if (graduationType == GRADUATED) it.graduatedMale++
                        else if (graduationType == EXPECTED) it.expectedMale++
                    }
                    isMale -> {
                        if (graduationType == GED) it.gedMale++
                        else it.otherCityMale++
                    }
                    !isMale && isFromDaegu -> {
                        if (graduationType == GRADUATED) it.graduatedFemale++
                        else if (graduationType == EXPECTED) it.expectedFemale++
                    }
                    !isMale -> {
                        if (graduationType == GED) it.gedFemale++
                        else it.otherCityFemale++
                    }
                }

                it.totalMale = it.graduatedMale + it.expectedMale + it.gedMale + it.otherCityMale
                it.totalFemale = it.graduatedFemale + it.expectedFemale + it.gedFemale + it.otherCityFemale
                it.total = it.totalFemale + it.totalMale
            }
        }

        return rateList
    }


    fun getApplicantCompetitionRate(): TotalAdmissionCompetitionRateResponse {
        val applicants = queryApplicantSpi.findAll()
        val info = TotalAdmissionCompetitionRateResponse()
        applicants.forEach {
            when (it.privacy.gender!!) {
                MALE -> {
                    when (it.education.graduationType) {
                        EXPECTED -> info.expectedMale++
                        GRADUATED -> info.graduatedMale++
                        GED -> info.gedMale++
                    }
                }

                FEMALE -> {
                    when (it.education.graduationType) {
                        EXPECTED -> info.expectedFemale++
                        GRADUATED -> info.graduatedFemale++
                        GED -> info.gedFemale++
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
        var index = 1
        applicants.forEach { applicant ->
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
                info.male = info.graduatedMale + info.expectedMale
                info.female = info.graduatedFemale + info.expectedFemale
                info.total = info.male + info.female
            }
        }
        userSchoolCityInfoList.sortBy { it.index }
        return userSchoolCityInfoList
    }

    private fun applyDetail(applyType: ApplyType): String {
        var apply = ""

        if (applyType == ApplyType.COMMON) {
            apply = "일반전형"
        } else if (applyType == ApplyType.MEISTER) {
            apply = "특별전형(마이스터인재)"
        } else if (applyType == ApplyType.LOCAL_FIRST) {
            apply = "특별전형(지역우선)"
        } else if (applyType.mainCategory == ApplyType.Category.SPECIAL &&
            applyType.subCategory == ApplyType.SubCategory.EQUALS_OPPORTUNITY ||
            applyType.subCategory == ApplyType.SubCategory.SOCIAL_DIVERSITY
        ) {
            apply = "특별전형(사회통합)"
        } else if (applyType.mainCategory == ApplyType.Category.EXCEPTIONAL) {
            apply = "특례입학"
        }

        return apply
    }
}