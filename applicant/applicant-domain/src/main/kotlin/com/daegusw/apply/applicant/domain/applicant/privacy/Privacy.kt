package com.daegusw.apply.applicant.domain.applicant.privacy

import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Address
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Merit
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Parent
import java.time.Instant

data class Privacy(
    val name: String,
    val birth: Instant,
    val gender: Gender,
    var phone: String,
    var photo: String,
    var schoolCode: String,
    var address: Address,
    var parent: Parent,
    var merit: Merit,
)