package com.dgswiphak.ida.persistence.secondary.entity.value

import jakarta.persistence.Embeddable

@Embeddable
class InterviewVO(

    val studyCompetence: Double? = 0.0,

    val computingCompetence: Double? = 0.0

)