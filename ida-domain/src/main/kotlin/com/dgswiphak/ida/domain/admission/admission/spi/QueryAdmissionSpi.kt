package com.dgswiphak.ida.domain.admission.admission.spi

import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.admission.admission.model.Admission

interface QueryAdmissionSpi : QuerySpi<Admission, Long> {
    override fun findById(id: Long): Admission?
}
