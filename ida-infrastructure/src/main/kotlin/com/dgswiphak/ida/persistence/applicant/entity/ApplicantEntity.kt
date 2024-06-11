package com.dgswiphak.ida.persistence.applicant.entity

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.persistence.applicant.entity.value.education.EmbeddedEducation
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.EmbeddedPrivacy
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "applicant")
class ApplicantEntity(
    id: EmbeddedMemberId,
    privacy: EmbeddedPrivacy?,
    education: EmbeddedEducation?
) {
    @EmbeddedId
    var id: EmbeddedMemberId = id
        protected set

    @Embedded
    var privacy: EmbeddedPrivacy? = privacy
        protected set

    @Embedded
    var education: EmbeddedEducation? = education
        protected set
}