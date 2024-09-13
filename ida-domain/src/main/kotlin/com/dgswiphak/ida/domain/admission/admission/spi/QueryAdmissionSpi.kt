package com.dgswiphak.ida.domain.admission.admission.spi

import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.admission.admission.model.value.type.Progress

interface QueryAdmissionSpi : QuerySpi<Admission, Long> {
    override fun findById(id: Long): Admission?

    fun findAllByProgress(progress: Progress): List<Admission>

    fun findByMemberId(memberId: Long): Admission?

    fun findAll(): List<Admission>
}
