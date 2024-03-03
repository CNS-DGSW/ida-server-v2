package com.dgswiphak.ida.persistence.secondary.entity

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.persistence.secondary.entity.value.AptitudeVO
import com.dgswiphak.ida.persistence.secondary.entity.value.InterviewVO
import jakarta.persistence.Embedded
import jakarta.persistence.EmbeddedId
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "secondary")
class SecondaryEntity(

    @EmbeddedId
    val id: EmbeddedMemberId,

    @Embedded
    val aptitudeVO: AptitudeVO,

    @Embedded
    val interviewVO: InterviewVO

)