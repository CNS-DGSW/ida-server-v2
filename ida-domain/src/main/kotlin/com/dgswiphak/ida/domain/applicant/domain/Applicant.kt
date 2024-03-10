package com.dgswiphak.ida.domain.applicant.domain

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.domain.value.detail.Education
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.Privacy

data class Applicant(
    val id: MemberId,
    var privacy: Privacy,
    var education: Education
) {
    fun updatePrivacy(privacy: Privacy) {
        this.privacy = privacy
    }

    fun updateEducation(education: Education) {
        this.education = education
    }
}