package com.dgswiphak.ida.domain.admission.score.model.value.type

enum class AchieveLevel(
    val value: Int
) {
    A(5),
    B(4),
    C(3),
    D(2),
    E(1),

    NONE(0)
    ;
}