package com.dgswiphak.ida.persistence.admission.admission.mapper

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.util.MapperUtils
import com.dgswiphak.ida.domain.admission.admission.model.Admission
import com.dgswiphak.ida.domain.admission.admission.model.value.AdmissionApplicant
import com.dgswiphak.ida.domain.admission.admission.model.value.Document
import com.dgswiphak.ida.persistence.admission.admission.entity.AdmissionEntity
import com.dgswiphak.ida.persistence.admission.admission.entity.value.AdmissionApplicantVO
import com.dgswiphak.ida.persistence.admission.admission.entity.value.DocumentVO
import com.dgswiphak.ida.persistence.admission.score.mapper.ScoreMapper
import org.springframework.stereotype.Component

@Component
class AdmissionMapper(
    private val scoreMapper: ScoreMapper
): Mapper<Admission, AdmissionEntity> {

    private val applicantMapper: AdmissionApplicantMapper = AdmissionApplicantMapper()
    private val documentMapper: DocumentMapper = DocumentMapper()

    override fun toDomain(entity: AdmissionEntity?): Admission? {
        return entity?.let {
            Admission(
                id = it.id,
                progress = it.progress,
                applicant = applicantMapper.toDomain(it.applicant),
                document = documentMapper.toDomain(it.document),
                score = scoreMapper.toDomain(it.score)
            )
        }
    }

    override fun toEntity(domain: Admission): AdmissionEntity {
        return AdmissionEntity(
            id = domain.id,
            progress = domain.progress,
            applicant = MapperUtils.convertToEntityIsNull(domain.applicant, applicantMapper),
            document = MapperUtils.convertToEntityIsNull(domain.document, documentMapper),
            score = MapperUtils.convertToEntityIsNull(domain.score, scoreMapper)
        )
    }

    inner class AdmissionApplicantMapper : Mapper<AdmissionApplicant, AdmissionApplicantVO> {
        override fun toDomain(entity: AdmissionApplicantVO?): AdmissionApplicant? {
            return entity?.let {
                AdmissionApplicant(
                    memberId = MemberId(it.memberId.value),
                    applyType = it.applyType
                )
            }
        }

        override fun toEntity(domain: AdmissionApplicant): AdmissionApplicantVO {
            return AdmissionApplicantVO(
                memberId = EmbeddedMemberId(domain.memberId.value),
                applyType = domain.applyType
            )
        }

    }

    inner class DocumentMapper : Mapper<Document, DocumentVO> {
        override fun toDomain(entity: DocumentVO?): Document? {
            return entity?.let {
                Document(
                    introduce = it.introduce,
                    studyPlane = it.studyPlane
                )
            }
        }

        override fun toEntity(domain: Document): DocumentVO {
            return DocumentVO(
                introduce = domain.introduce,
                studyPlane = domain.studyPlane
            )
        }

    }
}
