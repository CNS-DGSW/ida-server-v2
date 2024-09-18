package com.daegusw.apply.applicant.application.port.out.persistence

import com.daegusw.apply.applicant.domain.applicant.Applicant
import com.daegusw.apply.member.id.MemberId

interface QueryApplicantPort {
    fun findById(id: MemberId): Applicant?
}