package com.daegusw.apply.core.data.entity.secondary.value

import javax.persistence.Embeddable

@Embeddable
class InterviewVO(

    val studyCompetence: Double? = 0.0,

    val computingCompetence: Double? = 0.0

)