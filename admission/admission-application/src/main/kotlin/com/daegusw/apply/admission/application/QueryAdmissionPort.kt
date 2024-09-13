package com.daegusw.apply.admission.application

import com.daegusw.apply.admission.domain.Admission
import com.daegusw.apply.member.id.MemberId

interface QueryAdmissionPort {
    fun findById(id: MemberId): Admission?
}