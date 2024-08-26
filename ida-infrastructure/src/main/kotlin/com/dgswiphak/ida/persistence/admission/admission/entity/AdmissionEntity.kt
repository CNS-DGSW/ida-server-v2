package com.dgswiphak.ida.persistence.admission.admission.entity

import com.dgswiphak.ida.domain.admission.admission.model.value.type.Progress
import com.dgswiphak.ida.persistence.admission.admission.entity.value.AdmissionApplicantVO
import com.dgswiphak.ida.persistence.admission.admission.entity.value.DocumentVO
import com.dgswiphak.ida.persistence.admission.score.entity.ScoreEntity
import jakarta.persistence.*

@Entity
@Table(name = "admission")
class AdmissionEntity(
    id: Long? = 0,
    progress: Progress? = Progress.NONE,
    applicant: AdmissionApplicantVO?,
    document: DocumentVO?,
    score: ScoreEntity?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id
        protected set

    @Enumerated(EnumType.STRING)
    var progress: Progress? = progress
        protected set

    @Embedded
    var applicant: AdmissionApplicantVO? = applicant
        protected set

    @Embedded
    var document: DocumentVO? = document
        protected set

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "score_id")
    var score: ScoreEntity? = score
        protected set
}
