package com.daegusw.apply.core.data.entity.admission

import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.core.data.entity.admission.value.AdmissionApplicantVO
import com.daegusw.apply.core.data.entity.admission.value.AdmissionStatusVO
import com.daegusw.apply.core.data.entity.admission.value.DocumentVO
import javax.persistence.*

@Entity
@Table(name = "admission")
class AdmissionEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    progress: Progress = Progress.WRITE,
    applicant: AdmissionApplicantVO?,
    document: DocumentVO?,
    admissionStatus: AdmissionStatusVO?,
) {
    @Enumerated(EnumType.STRING)
    var progress = progress
        protected set

    @Embedded
    var document = document
        protected set

    @Embedded
    var applicant = applicant
        protected set

    @Embedded
    var admissionStatus = admissionStatus
        protected set
}