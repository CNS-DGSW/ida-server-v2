package com.daegusw.apply.admission.domain.admission

import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.admission.domain.admission.value.AdmissionApplicant
import com.daegusw.apply.admission.domain.admission.value.Status
import com.daegusw.apply.admission.domain.admission.value.Document

class Admission(
    val id: Long? = 0,
    val progress: Progress = Progress.WRITE,
    var applicant: AdmissionApplicant? = null,
    var document: Document? = null,
    var status: Status? = Status()
) {
    fun updateDocument(document: Document) {
        this.document = document
    }

    fun updateType(applicant: AdmissionApplicant) {
        this.applicant = applicant
    }
}