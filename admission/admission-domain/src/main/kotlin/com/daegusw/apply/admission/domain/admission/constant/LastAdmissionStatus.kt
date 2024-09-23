package com.daegusw.apply.admission.domain.admission.constant

enum class LastAdmissionStatus(
    val message: String
) {
    NONE("1차 전형 발표일은 2024년10월23일 수요일 오전 10:00시 입니다."),
    LAST_ROUND_PASS("1차 전형 합격입니다."),
    LAST_ROUND_FAIL("1차 전형 탈락입니다.")
}