package com.daegusw.apply.applicant.application.port.out.persistence

import com.daegusw.apply.applicant.domain.applicant.Applicant

interface CommandApplicantPort {
    fun save(applicant: Applicant)
}