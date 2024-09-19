package com.daegusw.apply.applicant.jpa.adapter.common

import com.daegusw.apply.applicant.domain.applicant.Applicant
import com.daegusw.apply.applicant.jpa.adapter.common.EducationMapper.toEducation
import com.daegusw.apply.applicant.jpa.adapter.common.EducationMapper.toEmbeddedEducation
import com.daegusw.apply.applicant.jpa.adapter.common.PrivacyMapper.toEmbeddedPrivacy
import com.daegusw.apply.applicant.jpa.adapter.common.PrivacyMapper.toPrivacy
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.applicant.ApplicantEntity
import com.daegusw.apply.member.id.MemberId

object ApplicantEntityMapper {
    fun toEntity(applicant: Applicant): ApplicantEntity {
        return ApplicantEntity(
            id = EmbeddedMemberId(applicant.id.value),
            privacy = applicant.privacy?.let { toEmbeddedPrivacy(it) },
            education = applicant.education?.let { toEmbeddedEducation(it) }
        )
    }

    fun toDomain(entity: ApplicantEntity?): Applicant? {
        return entity?.let {
            Applicant(
                id = MemberId(it.id.value),
                privacy = it.privacy?.let { toPrivacy(it) },
                education = it.education?.let { toEducation(it) }
            )
        }
    }
}