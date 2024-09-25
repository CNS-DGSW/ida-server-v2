package com.daegusw.apply.admin.domain.admin.dto

import com.daegusw.apply.admin.domain.secondary.domain.Secondary
import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.applicant.domain.applicant.Applicant

data class SecondaryTableResponse(
    val index: Int,
    val submitNumber: Int,
    val examNumber: Int,
    val name: String? = "",
    val gender: String? = "",
    val city: String? = "",
    val school: String? = "",
    val graduationType: String? = "",
    val firstApplyType: String? = "",
    val firstDetailApplyType: String? = "",
    val generalScore: Double? = 0.0,
    val specialScore: Double? = 0.0,
    val absenceScore: Double? = 0.0,
    val volunteerScore: Double? = 0.0,
    val additionalScore: Double? = 0.0,
    val firstScore: Double? = 0.0,
    val jopScore: Double? = 0.0,
    val studyCompetence: Double? = 0.0,
    val computingCompetence: Double? = 0.0,
    val interviewTotalScore: Double? = 0.0,
    val secondarySpecialScore: Double? = 0.0,
    val secondaryRanking: Int? = 0,
    val secondaryCommonScore: Double? = 0.0,
    val secondaryCommonRankin: Int? = 0,
    val isFinalPass: Boolean? = false,
    val finalPassApplyType: String? = ""
) {

    constructor(index: Int, applicant: Applicant?, admission: Admission?, secondary: Secondary?) : this(
        index = index,
        submitNumber = index,
        examNumber = index,
        name = applicant?.privacy?.name,
        gender = applicant?.privacy?.gender?.name,
        city = applicant?.education?.school?.city,
        school = applicant?.education?.school?.name,
        graduationType = applicant?.education?.graduationType?.name,
//        firstApplyType 1차 합격 전형
//        firstDetailApplyType 1차 합격 세부 전형
//        generalScore = admission?.score?.generalScore,
//        specialScore = admission?.score?.specialScore,
//        absenceScore = admission?.score?.absence,
//        volunteerScore = admission?.score?.volunteer,
//        additionalScore = admission?.score?.additional,
//        firstScore 1차 성적
        jopScore = secondary?.aptitude?.jopScore,
        studyCompetence = secondary?.interview?.studyCompetence,
        computingCompetence = secondary?.interview?.computingCompetence,
//        interviewTotalScore 심층 면접 총 점수
//        secondarySpecialScore 2차 특별전형 성적
//        secondaryRanking 2차 특별전형 석차
//        secondaryCommonScore 2차 일반전형 성적
//        secondaryCommonRankin 2차 특별전형 석차
//        isFinalPass 최종 합격 여부
//        finalPassApplyType 최종 합격 전형
    )
}