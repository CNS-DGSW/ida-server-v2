package com.daegusw.apply.admin.domain.admin.service

import com.daegusw.apply.admin.domain.admin.dto.ApplicantCompetitionRateResponse
import com.daegusw.apply.admin.domain.admin.dto.ApplicantGraduationTypeCompetitionRateResponse
import com.daegusw.apply.admin.domain.admin.dto.ApplicantSchoolCompetitionRateResponse
import com.daegusw.apply.admin.domain.admin.dto.UserSchoolCityInfoResponse
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.applicant.domain.applicant.Applicant
import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType.*
import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import org.springframework.stereotype.Service
import kotlin.math.round

@Service
class AdminStatisticsService(
    private val queryApplicantPort: QueryApplicantPort,
    private val queryAdmissionPort: QueryAdmissionPort,
) {

    fun getApplicantCompetitionRate(): List<ApplicantCompetitionRateResponse> {
        val admission = queryAdmissionPort.findAllByProgress(Progress.APPLY)
        val rateList: MutableList<ApplicantCompetitionRateResponse> = mutableListOf(
            ApplicantCompetitionRateResponse("일반전형"),
            ApplicantCompetitionRateResponse("특별전형(사회통합)"),
            ApplicantCompetitionRateResponse("특별전형(마이스터인재)"),
            ApplicantCompetitionRateResponse("특별전형(지역우선)"),
            ApplicantCompetitionRateResponse("특례입학")
        )

        admission.map {
            var rate: ApplicantCompetitionRateResponse? = rateList.find { item ->
                item.applyType == applyDetail(it.applicant!!.type)
            }
            val applicantInfo: Applicant? = queryApplicantPort.findById(it.applicant!!.member)

            if (rate == null) rate = ApplicantCompetitionRateResponse(applyDetail(it.applicant!!.type))

            if (applicantInfo!!.privacy?.gender == Gender.MALE) {
                if (applicantInfo.privacy?.address!!.streetAddress.contains("대구광역시")) rate.daeguMale++
                else rate.otherMale++
            } else {
                if (applicantInfo.privacy?.address!!.streetAddress.contains("대구광역시")) rate.daeguFemale++
                else rate.otherFemale++
            }
        }

        rateList.forEach {
            it.total = it.daeguMale + it.daeguFemale + it.otherMale + it.otherFemale
            it.rate = round((it.total / (if (it.personnel == 0) 1.0 else it.personnel.toDouble())) * 100) / 100.0
        }

        return rateList
    }

    fun getApplicantSchoolCompetitionRate(): List<ApplicantSchoolCompetitionRateResponse> {
        val applicants = queryApplicantPort.findAll()
        val rateList: MutableList<ApplicantSchoolCompetitionRateResponse> = mutableListOf(
            ApplicantSchoolCompetitionRateResponse("일반전형"),
            ApplicantSchoolCompetitionRateResponse("특별전형(사회통합)"),
            ApplicantSchoolCompetitionRateResponse("특별전형(마이스터인재)"),
            ApplicantSchoolCompetitionRateResponse("특별전형(지역우선)"),
            ApplicantSchoolCompetitionRateResponse("특례입학")
        )

        applicants.forEach { applicant ->
            val admission = queryAdmissionPort.findByMemberId(applicant.id)
            val rate: ApplicantSchoolCompetitionRateResponse? = rateList.find { item ->
                item.apply == applyDetail(admission!!.applicant!!.type)
            }

            rate?.let {
                val isMale = applicant.privacy?.gender == Gender.MALE
                val isFromDaegu = applicant.education?.school!!.city == "대구광역시"
                val graduationType = applicant.education?.graduationType

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

    fun getApplicantGraduationTypeCompetitionRate(): ApplicantGraduationTypeCompetitionRateResponse {
        val applicants = queryApplicantPort.findAll()
        val info = ApplicantGraduationTypeCompetitionRateResponse()
        applicants.forEach {
            when (it.privacy!!.gender) {
                Gender.MALE -> {
                    when (it.education?.graduationType) {
                        EXPECTED -> info.expectedMale++
                        GRADUATED -> info.graduatedMale++
                        GED -> info.gedMale++
                        null -> TODO()
                    }
                }

                Gender.FEMALE -> {
                    when (it.education?.graduationType) {
                        EXPECTED -> info.expectedFemale++
                        GRADUATED -> info.graduatedFemale++
                        GED -> info.gedFemale++
                        null -> TODO()
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
        val applicants = queryApplicantPort.findAll()
        val userSchoolCityInfoList: MutableList<UserSchoolCityInfoResponse> = mutableListOf()
        var index = 1
        applicants.forEach { applicant ->
            val school = applicant.education?.school
            if (school != null && applicant.education?.graduationType != GED) {
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
                when (applicant.privacy?.gender!!) {
                    Gender.MALE -> {
                        if (applicant.education?.graduationType == GRADUATED) info.graduatedMale++
                        else info.expectedMale++
                    }

                    Gender.FEMALE -> {
                        if (applicant.education?.graduationType == GRADUATED) info.graduatedFemale++
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