package com.dgswiphak.ida.domain.applicant.spi.query

import com.dgswiphak.ida.domain.applicant.model.Applicant

interface CommandApplicantSpi {
    fun save(applicant: Applicant): Applicant?
}