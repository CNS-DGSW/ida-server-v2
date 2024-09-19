package com.daegusw.apply.admission.application.port.out.persistence

import com.daegusw.apply.admission.domain.admission.Admission

interface CommandAdmissionPort {
    fun save(admission: Admission): Admission
}