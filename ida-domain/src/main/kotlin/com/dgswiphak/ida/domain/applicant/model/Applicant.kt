package com.dgswiphak.ida.domain.applicant.model

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.model.value.education.Education
import com.dgswiphak.ida.domain.applicant.model.value.privacy.Privacy

class Applicant(
    id: MemberId,
    privacy: Privacy = Privacy(),
    education: Education = Education(),
) {
    val id: MemberId = id
    var privacy: Privacy = privacy
    var education: Education = education

    fun updatePrivacy(privacy: Privacy) {
        this.privacy = privacy
    }

    fun updateEducation(education: Education) {
        this.education = education
    }
}