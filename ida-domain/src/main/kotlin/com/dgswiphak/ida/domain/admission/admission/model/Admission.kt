package com.dgswiphak.ida.domain.admission.admission.model

import com.dgswiphak.ida.domain.admission.admission.model.value.AdmissionApplicant
import com.dgswiphak.ida.domain.admission.admission.model.value.Document
import com.dgswiphak.ida.domain.admission.admission.model.value.type.Progress
import com.dgswiphak.ida.domain.admission.score.model.Score

class Admission(
    val id: Long? = 0,
    progress: Progress? = Progress.NONE,
    applicant: AdmissionApplicant? = null,
    document: Document? = null,
    score: Score? = null
) {
    var progress: Progress? = progress
        private set
    var applicant = applicant
        private set
    var document = document
        private set
    var score: Score? = score
        private set

    fun updateType(applicant: AdmissionApplicant) {
        this.applicant = applicant
    }

    fun updateDocument(document: Document) {
        this.document = document
    }

    fun updateScore(score: Score) {
        this.score = score
    }
}
