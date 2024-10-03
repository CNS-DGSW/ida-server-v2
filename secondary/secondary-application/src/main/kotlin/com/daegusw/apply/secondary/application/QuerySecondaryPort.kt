package com.daegusw.apply.secondary.application

import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.secondary.domain.Secondary

interface QuerySecondaryPort {
    fun findByAdmission(admission: Admission): Secondary?
}