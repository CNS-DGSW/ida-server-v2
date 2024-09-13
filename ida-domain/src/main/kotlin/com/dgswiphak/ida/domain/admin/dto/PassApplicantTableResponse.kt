package com.dgswiphak.ida.domain.admin.dto

import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.admission.admission.model.value.type.ApplyType
import com.dgswiphak.ida.domain.applicant.model.Applicant
import java.time.Instant

data class PassApplicantTableResponse(
    val index: Int,
    val examNumber: String? = "",
    val name: String? = "",
    val gender: String? = "",
    val city: String? = "",
    val school: String? = "",
    val graduationType: String? = "",
    val birth: Instant?,
    val studentTelNumber: String? = "",
    val parentTelNumber: String? = "",
    val address: String? = "",
    val applyType: String? = "",
    val applyDetailType: String? = "",
    val firstApplyType: String? = "",
    val isFinalPass: String? = "",
    val finalApplyType: String? = ""
) {
    constructor(index: Int, admission: Admission?, applicant: Applicant?) : this(
        index = index,
        examNumber = index.toString(),
        name = applicant?.privacy?.name,
        gender = applicant?.privacy?.gender?.value,
        city = applicant?.education?.school?.city,
        school = applicant?.education?.school?.name,
        graduationType = applicant?.education?.graduationType?.value,
        birth = applicant?.privacy?.birth!!,
        studentTelNumber = applicant.privacy.phone?.value,
        parentTelNumber = applicant.privacy.parent?.phone?.value,
        address = applicant.privacy.address?.detailAddress,
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
        applyDetailType = admission?.applicant?.applyType?.value,
        // firstApplyType 1차 합격 전형
        // isFinalPass 최종 합격 여부
        // finalApplyType 최종 합격 전형
    )
}

