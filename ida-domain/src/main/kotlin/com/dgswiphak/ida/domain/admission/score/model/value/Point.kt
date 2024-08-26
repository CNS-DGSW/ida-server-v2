package com.dgswiphak.ida.domain.admission.score.model.value

@JvmInline
value class Point(
    val value: Int
) {
    init {
        require(value >= 0) { "점수는 0이상 이어야 합니다." }
    }
}