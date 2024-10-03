package com.daegusw.apply.secondary.domain

import com.daegusw.apply.secondary.domain.value.Aptitude
import com.daegusw.apply.secondary.domain.value.Examinee
import com.daegusw.apply.secondary.domain.value.Interview

class Secondary(
    val id: Long? = 0,
    val examinee: Examinee,
    val aptitude: Aptitude,
    val interview: Interview
)