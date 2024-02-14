package com.dgswiphak.ida.persistence.applicant.entity

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
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