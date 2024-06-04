package com.dgswiphak.ida.domain.applicant.spi.query

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.applicant.model.Applicant

interface QueryApplicantSpi: QuerySpi<Applicant, MemberId> {
    override fun findById(id: MemberId): Applicant?
}