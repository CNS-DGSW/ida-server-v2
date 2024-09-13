package com.daegusw.apply.admission.domain

import com.daegusw.apply.admission.domain.constant.Progress
import com.daegusw.apply.admission.domain.value.AdmissionApplicant
import com.daegusw.apply.admission.domain.value.Document

class Admission(
    val id: Long? = 0,
    val progress: Progress,
    val applicant: AdmissionApplicant,
    val document: Document,
)