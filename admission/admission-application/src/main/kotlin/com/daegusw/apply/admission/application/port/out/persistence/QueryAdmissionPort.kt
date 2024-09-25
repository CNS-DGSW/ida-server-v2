package com.daegusw.apply.admission.application.port.out.persistence

import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.member.id.MemberId

interface QueryAdmissionPort {
    fun findByMemberId(id: MemberId): Admission?

    fun findAll(): List<Admission>

    fun findAllByProgress(progress: Progress): List<Admission>
}