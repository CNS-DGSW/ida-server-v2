package com.daegusw.apply.core.data.entity.applicant

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.applicant.value.EmbeddedEducation
import com.daegusw.apply.core.data.entity.applicant.value.EmbeddedPrivacy
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "applicant")
class ApplicantEntity(
    @EmbeddedId
    val id: EmbeddedMemberId,
    privacy: EmbeddedPrivacy?,
    education: EmbeddedEducation?
) {
    @Embedded
    var privacy = privacy
        protected set

    @Embedded
    var education = education
        protected set
}