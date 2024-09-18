package com.daegusw.apply.applicant.application.common.dto

import com.daegusw.apply.applicant.domain.applicant.privacy.Privacy
import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import java.time.LocalDate

data class InformationDto(
    val name: String,
    val gender: Gender,
    val birth: LocalDate,
    val phone: String
) {
    constructor(privacy: Privacy?): this(
        name = privacy?.name ?: "",
        gender = privacy?.gender ?: Gender.MALE,
        birth = privacy?.birth ?: LocalDate.now(),
        phone = privacy?.phone ?: ""
    )
}