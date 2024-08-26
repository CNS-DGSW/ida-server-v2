package com.dgswiphak.ida.domain.admission.admission.spi

import com.dgswiphak.ida.domain.admission.admission.model.Admission

interface CommandAdmissionSpi {
    fun save(admission: Admission): Admission?
}