package com.daegusw.apply.applicant.domain.applicant

import com.daegusw.apply.applicant.domain.applicant.education.Education
import com.daegusw.apply.applicant.domain.applicant.privacy.Privacy
import com.daegusw.apply.member.id.MemberId

class Applicant(
    val id: MemberId,
    var privacy: Privacy? = null,
    var education: Education? = null
) {
    fun updatePrivacy(privacy: Privacy) {
        this.privacy = privacy
    }

    fun updateEducation(education: Education) {
        this.education = education
    }
}