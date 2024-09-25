package com.daegusw.apply.admin.domain.secondary.domain

import com.daegusw.apply.admin.domain.secondary.domain.value.Aptitude
import com.daegusw.apply.admin.domain.secondary.domain.value.Interview
import com.daegusw.apply.member.id.MemberId

data class Secondary(

    val memberId: MemberId,

    val aptitude: Aptitude,

    val interview: Interview

)