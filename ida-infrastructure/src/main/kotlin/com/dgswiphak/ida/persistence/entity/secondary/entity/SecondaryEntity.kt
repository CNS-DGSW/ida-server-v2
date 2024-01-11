package com.dgswiphak.ida.persistence.entity.secondary.entity

import com.dgswiphak.ida.persistence.entity.secondary.entity.value.AptitudeVO
import com.dgswiphak.ida.persistence.entity.secondary.entity.value.InterviewVO
import jakarta.persistence.*

@Entity
@Table(name = "secondary")
class SecondaryEntity(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Embedded
    val aptitudeVO: AptitudeVO,

    @Embedded
    val interviewVO: InterviewVO

)