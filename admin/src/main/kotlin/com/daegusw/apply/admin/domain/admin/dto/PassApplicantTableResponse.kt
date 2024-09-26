package com.daegusw.apply.admin.domain.admin.dto

import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.daegusw.apply.applicant.domain.applicant.Applicant
import java.time.LocalDate

data class PassApplicantTableResponse(
    val index: Int,
    val examNumber: String? = "",
    val name: String? = "",
    val gender: String? = "",
    val city: String? = "",
    val school: String? = "",
    val graduationType: String? = "",
    val birth: LocalDate,
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
        gender = applicant?.privacy?.gender?.name,
        city = applicant?.education?.school?.city,
        school = applicant?.education?.school?.name,
        graduationType = applicant?.education?.graduationType?.name,
        birth = applicant?.privacy?.birth!!,
        studentTelNumber = applicant.privacy?.phone,
        parentTelNumber = applicant.privacy?.parent?.phone,
        address = applicant.privacy?.address?.detailAddress,
        applyType = admission?.let {
            when {
                it.applicant?.type == ApplyType.COMMON -> "일반전형"
                it.applicant?.type == ApplyType.MEISTER -> "특별전형(마이스터인재)"
                it.applicant?.type == ApplyType.LOCAL_FIRST -> "특별전형(지역우선)"
                it.applicant?.type?.mainCategory == ApplyType.Category.SPECIAL &&
                        (it.applicant?.type?.subCategory == ApplyType.SubCategory.EQUALS_OPPORTUNITY ||
                                it.applicant?.type?.subCategory == ApplyType.SubCategory.SOCIAL_DIVERSITY) -> "특별전형(사회통합)"

                it.applicant?.type?.mainCategory == ApplyType.Category.EXCEPTIONAL -> "특례입학"
                else -> ""
            }
        } ?: "",
        applyDetailType = admission?.applicant?.type?.value,
        // firstApplyType 1차 합격 전형
        // isFinalPass 최종 합격 여부
        // finalApplyType 최종 합격 전형
    )
}

