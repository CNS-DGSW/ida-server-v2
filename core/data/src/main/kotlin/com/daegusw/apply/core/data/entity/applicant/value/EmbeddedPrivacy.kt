package com.daegusw.apply.core.data.entity.applicant.value

import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import java.time.LocalDate
import javax.persistence.*

@Embeddable
data class EmbeddedPrivacy(
    val name: String,

    val birth: LocalDate,

    @Enumerated(EnumType.STRING)
    val gender: Gender,

    val phone: String,

    val photo: String,

    @Embedded
    val address: AddressVO?,

    @Embedded
    val parent: ParentVO?,

    @Embedded
    val merit: MeritVO?
)