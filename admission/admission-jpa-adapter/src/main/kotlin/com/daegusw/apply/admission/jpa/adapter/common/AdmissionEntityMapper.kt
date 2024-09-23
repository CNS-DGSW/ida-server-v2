package com.daegusw.apply.admission.jpa.adapter.common

import com.daegusw.apply.admission.domain.admission.Admission
import com.daegusw.apply.admission.domain.admission.value.AdmissionApplicant
import com.daegusw.apply.admission.domain.admission.value.AdmissionStatus
import com.daegusw.apply.admission.domain.admission.value.Document
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.admission.AdmissionEntity
import com.daegusw.apply.core.data.entity.admission.value.AdmissionApplicantVO
import com.daegusw.apply.core.data.entity.admission.value.AdmissionStatusVO
import com.daegusw.apply.core.data.entity.admission.value.DocumentVO
import com.daegusw.apply.member.id.MemberId

object AdmissionEntityMapper {
    fun toEntity(domain: Admission): AdmissionEntity {
        return AdmissionEntity(
            id = domain.id,
            progress = domain.progress,
            applicant = domain.applicant?.let { toAdmissionApplicantVO(it) },
            document = domain.document?.let { toDocumentVO(it) },
            admissionStatus = domain.admissionStatus?.let { toAdmissionStatusVO(it) }
        )
    }

    fun toDomain(entity: AdmissionEntity?): Admission? {
        return entity?.let {
            Admission(
                id = it.id,
                progress = it.progress,
                applicant = it.applicant?.let { toAdmissionApplicant(it) },
                document = it.document?.let { toDocument(it) },
                admissionStatus = it.admissionStatus?.let { toAdmissionStatus(it) }
            )
        }
    }

    private fun toAdmissionApplicantVO(applicant: AdmissionApplicant): AdmissionApplicantVO {
        return AdmissionApplicantVO(
            member = EmbeddedMemberId.of(applicant.member),
            type = applicant.type
        )
    }

    private fun toDocumentVO(document: Document): DocumentVO {
        return DocumentVO(
            introduce = document.introduce,
            studyPlan = document.studyPlan
        )
    }

    private fun toAdmissionStatusVO(admissionStatus: AdmissionStatus): AdmissionStatusVO {
        return AdmissionStatusVO(
            firstAdmissionStatus = admissionStatus.firstAdmissionStatus,
            lastAdmissionStatus = admissionStatus.lastAdmissionStatus
        )
    }

    private fun toAdmissionApplicant(applicant: AdmissionApplicantVO?): AdmissionApplicant? {
        return applicant?.let {
            AdmissionApplicant(
                member = MemberId(it.member.value),
                type = it.type
            )
        }

    }

    private fun toDocument(document: DocumentVO?): Document? {
        return document?.let {
            Document(
                introduce = document.introduce,
                studyPlan = document.studyPlan
            )
        }
    }

    private fun toAdmissionStatus(admissionStatus: AdmissionStatusVO?): AdmissionStatus? {
        return admissionStatus?.let {
            AdmissionStatus(
                firstAdmissionStatus = it.firstAdmissionStatus,
                lastAdmissionStatus = it.lastAdmissionStatus
            )
        }
    }
}