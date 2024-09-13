package com.dgswiphak.ida.domain.admin.dto

import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.applicant.model.Applicant
import com.dgswiphak.ida.domain.secondary.model.Secondary

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
        gender = applicant?.privacy?.gender?.value,
        city = applicant?.education?.school?.city,
        school = applicant?.education?.school?.name,
        graduationType = applicant?.education?.graduationType?.value,
//        firstApplyType,
//        firstDetailApplyType,
        generalScore = admission?.score?.generalScore,
        specialScore = admission?.score?.specialScore,
        absenceScore = admission?.score?.absence,
        volunteerScore = admission?.score?.volunteer,
        additionalScore = admission?.score?.additional,
//        firstScore,
        jopScore = secondary?.aptitude?.jopScore,
        studyCompetence = secondary?.interview?.studyCompetence,
        computingCompetence = secondary?.interview?.computingCompetence,
//        interviewTotalScore,
//        secondarySpecialScore,
//        secondaryRanking,
//        secondaryCommonScore,
//        secondaryCommonRankin,
//        isFinalPass,
//        finalPassApplyType
    )
}