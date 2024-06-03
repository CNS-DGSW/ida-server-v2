package com.dgswiphak.ida.persistence.secondary.entity.value

import jakarta.persistence.Embeddable

@Embeddable
class InterviewVO(

    val studyCompetence: Int? = 0,

    val computingCompetence: Int? = 0

)