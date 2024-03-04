package com.dgswiphak.ida.persistence.applicant.entity

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.EmbeddedPrivacy
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity

@Entity(name = "applicant")
class ApplicantEntity(
    @EmbeddedId
    val id: EmbeddedMemberId,

    @Embedded
    val privacy: EmbeddedPrivacy?
)