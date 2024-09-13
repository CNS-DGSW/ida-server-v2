package com.daegusw.apply.admission.jpa.adapter.common

import com.daegusw.apply.admission.domain.Admission
import com.daegusw.apply.admission.domain.value.AdmissionApplicant
import com.daegusw.apply.admission.domain.value.Document
import com.daegusw.apply.core.data.entity.admission.AdmissionEntity
import com.daegusw.apply.core.data.entity.admission.value.AdmissionApplicantVO
import com.dgswiphak.ida.persistence.admission.admission.entity.value.DocumentVO

class AdmissionEntityMapper {
    companion object {
        fun toDomain(entity: AdmissionEntity?): Admission? {
            return entity?.let {
                Admission(
                    id = entity.id,
                    progress = entity.progress,
                    applicant = toApplicant(entity.applicant) ?: TODO(),
                    document = toDocument(entity.document) ?:TODO(),
                )
            }
        }

        fun toEntity(domain: Admission): AdmissionEntity {
            return AdmissionEntity(
                id = domain.id,
                progress = domain.progress,
                applicant = toApplicantVO(domain.applicant),
                document = toDocumentVO(domain.document)
            )
        }

        private fun toApplicant(entity: AdmissionApplicantVO?): AdmissionApplicant? {
            return entity?.let {
                AdmissionApplicant(
                    member = MemberIdMapper.toDomain(it.member),
                    type = it.type
                )
            }
        }

        private fun toApplicantVO(domain: AdmissionApplicant): AdmissionApplicantVO {
            return AdmissionApplicantVO(
                member = MemberIdMapper.toEntity(domain.member),
                type = domain.type
            )
        }

        private fun toDocument(entity: DocumentVO?): Document? {
            return entity?.let {
                Document(
                    introduce = it.introduce,
                    studyPlane = it.studyPlane
                )
            }
        }

        private fun toDocumentVO(domain: Document): DocumentVO {
            return DocumentVO(
                introduce = domain.introduce,
                studyPlane = domain.studyPlane
            )
        }


    }
}