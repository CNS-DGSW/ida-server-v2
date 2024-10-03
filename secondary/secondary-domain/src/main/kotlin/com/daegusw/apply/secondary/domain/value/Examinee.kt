package com.daegusw.apply.secondary.domain.value

import com.daegusw.apply.admission.domain.admission.Admission

data class Examinee(
    val admission: Admission,
    val examCode: Long
)