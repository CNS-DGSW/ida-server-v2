package com.dgswiphak.ida.domain.admin.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.admin.dto.ApplicantSchoolCompetitionRate
import com.dgswiphak.ida.domain.admin.dto.ApplicantCompetitionRate
import com.dgswiphak.ida.domain.admin.dto.ApplicantGraduationTypeCompetitionRate
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

    fun getApplicantCompetitionRate(): List<ApplicantCompetitionRate> {
        val admission = queryAdmissionSpi.findAllByProgress(Progress.APPLY)
        val rateList: MutableList<ApplicantCompetitionRate> = mutableListOf(
            ApplicantCompetitionRate("일반전형"),
            ApplicantCompetitionRate("특별전형(사회통합)"),
            ApplicantCompetitionRate("특별전형(마이스터인재)"),
            ApplicantCompetitionRate("특별전형(지역우선)"),
            ApplicantCompetitionRate("특례입학")
        )

        admission.map {
            var rate: ApplicantCompetitionRate? = rateList.find { item ->
                item.applyType == applyDetail(it.applicant!!.applyType)
            }
            val applicantInfo: Applicant? = queryApplicantSpi.findById(it.applicant!!.memberId)

            if (rate == null) rate = ApplicantCompetitionRate(applyDetail(it.applicant!!.applyType))

            if (applicantInfo!!.privacy.gender == MALE) {
                if (applicantInfo.privacy.address!!.streetAddress.contains("대구광역시")) rate.daeguMale++
                else rate.otherMale++
            } else {
                if (applicantInfo.privacy.address!!.streetAddress.contains("대구광역시")) rate.daeguFemale++
                else rate.otherFemale++
            }
        }

        rateList.forEach {
            it.total = it.daeguMale + it.daeguFemale + it.otherMale + it.otherFemale
            it.rate = round((it.total / (if (it.personnel == 0) 1.0 else it.personnel.toDouble())) * 100) / 100.0
        }

        return rateList
    }

    fun getApplicantSchoolCompetitionRate(): List<ApplicantSchoolCompetitionRate> {
        val applicants = queryApplicantSpi.findAll()
        val rateList: MutableList<ApplicantSchoolCompetitionRate> = mutableListOf(
            ApplicantSchoolCompetitionRate("일반전형"),
            ApplicantSchoolCompetitionRate("특별전형(사회통합)"),
            ApplicantSchoolCompetitionRate("특별전형(마이스터인재)"),
            ApplicantSchoolCompetitionRate("특별전형(지역우선)"),
            ApplicantSchoolCompetitionRate("특례입학")
        )

        applicants.forEach { applicant ->
            val admission = queryAdmissionSpi.findByMemberId(applicant.id.value)
            val rate: ApplicantSchoolCompetitionRate? = rateList.find { item ->
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

    fun getApplicantGraduationTypeCompetitionRate(): ApplicantGraduationTypeCompetitionRate {
        val applicants = queryApplicantSpi.findAll()
        val info = ApplicantGraduationTypeCompetitionRate()
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

    // TODO :: 날짜 및 지역별 가입, 작성, 제출 비율 테이블 추가

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