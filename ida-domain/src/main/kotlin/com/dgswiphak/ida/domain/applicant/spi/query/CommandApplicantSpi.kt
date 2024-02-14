package com.dgswiphak.ida.domain.applicant.spi.query

import com.dgswiphak.ida.domain.applicant.domain.Applicant

interface CommandApplicantSpi {
    fun save(applicant: Applicant): Applicant?
}