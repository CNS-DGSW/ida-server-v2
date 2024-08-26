package com.dgswiphak.ida.domain.admission.score.model

abstract class Score(
    val id: Long? = 0,
    var generalScore: Double = 0.0,
    var specialScore: Double = 0.0,
    var absence: Double = 0.0,
    var volunteer: Double = 0.0,
    var additional: Double = 0.0
)