package com.daegusw.apply.admission.domain.admission.constant

enum class Progress(
    val value: String
) {
    WRITE("작성 중"),
    SUBMITTED("제출"),
    APPROVED("승인"),
    REJECTED("반려"),
    RECEIVED("접수"),
    FIRST_PASSED("1차 합격"),
    FIRST_FAILED("1차 불합격"),
    PASSED("최종 합격"),
    FAILED("최종 불합격"),
}