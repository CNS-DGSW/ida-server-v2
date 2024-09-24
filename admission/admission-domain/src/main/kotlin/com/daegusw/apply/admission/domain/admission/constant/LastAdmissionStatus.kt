package com.daegusw.apply.admission.domain.admission.constant

enum class LastAdmissionStatus(
    val message: String
) {
    NONE("최종 결과 발표일은 2024년10월30일 수요일 오전 10:00시 입니다."),
    LAST_ROUND_PASS("최종 합격입니다."),
    LAST_ROUND_FAIL("최종 탈락입니다.")
}