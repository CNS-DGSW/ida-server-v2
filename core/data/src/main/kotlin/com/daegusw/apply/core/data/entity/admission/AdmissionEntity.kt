package com.daegusw.apply.core.data.entity.admission

import com.daegusw.apply.admission.domain.constant.Progress
import com.daegusw.apply.core.data.entity.admission.value.AdmissionApplicantVO
import com.dgswiphak.ida.persistence.admission.admission.entity.value.DocumentVO
import javax.persistence.*

@Entity
@Table(name = "admission")
class AdmissionEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = 0,
    progress: Progress,
    applicant: AdmissionApplicantVO,
    document: DocumentVO
) {
    @Enumerated(EnumType.STRING)
    var progress = progress
        protected set

    @Embedded
    var applicant = applicant
        protected set

    @Embedded
    var document = document
        protected set
}