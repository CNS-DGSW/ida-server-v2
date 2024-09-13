package com.dgswiphak.ida.domain.admin.dto

import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.admission.admission.model.value.type.ApplyType
import com.dgswiphak.ida.domain.applicant.model.Applicant

data class FirstTableResponse(
    val index: Int,
    val submitNumber: Int,
    val examNumber: Int,
    val name: String? = "",
    val gender: String? = "",
    val address: String? = "",
    val school: String? = "",
    val graduationType: String? = "",
    val applyType: String? = "",
    val detailApplyType: String? = "",
    val generalScore: Double? = 0.0,
    val specialScore: Double? = 0.0,
    val absenceScore: Double? = 0.0,
    val volunteerScore: Double? = 0.0,
    val additionalScore: Double? = 0.0,
    val firstScore: Double? = 0.0,
) {

    constructor(index: Int, applicant: Applicant?, admission: Admission?) : this(
        index = index,
        submitNumber = index,
        examNumber = index,
        name = applicant?.privacy?.name,
        gender = applicant?.privacy?.gender?.value,
        address = applicant?.privacy?.address?.streetAddress,
        school = applicant?.education?.school?.name,
        graduationType = applicant?.education?.graduationType?.value,
        applyType = admission?.let {
            when {
                it.applicant?.applyType == ApplyType.COMMON -> "일반전형"
                it.applicant?.applyType == ApplyType.MEISTER -> "특별전형(마이스터인재)"
                it.applicant?.applyType == ApplyType.LOCAL_FIRST -> "특별전형(지역우선)"
                it.applicant?.applyType?.mainCategory == ApplyType.Category.SPECIAL &&
                        (it.applicant?.applyType?.subCategory == ApplyType.SubCategory.EQUALS_OPPORTUNITY ||
                                it.applicant?.applyType?.subCategory == ApplyType.SubCategory.SOCIAL_DIVERSITY) -> "특별전형(사회통합)"

                it.applicant?.applyType?.mainCategory == ApplyType.Category.EXCEPTIONAL -> "특례입학"
                else -> ""
            }
        } ?: "",
        detailApplyType = admission?.applicant?.applyType?.value,
        generalScore = admission?.score?.generalScore,
        specialScore = admission?.score?.specialScore,
        absenceScore = admission?.score?.absence,
        volunteerScore = admission?.score?.volunteer,
        additionalScore = admission?.score?.additional
        // firstScore 1차 성적
    )
}