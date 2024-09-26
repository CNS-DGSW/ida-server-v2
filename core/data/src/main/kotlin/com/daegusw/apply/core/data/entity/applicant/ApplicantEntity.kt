package com.daegusw.apply.core.data.entity.applicant

import com.daegusw.apply.core.data.common.BaseMemberIdEntity
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.applicant.value.EmbeddedEducation
import com.daegusw.apply.core.data.entity.applicant.value.EmbeddedPrivacy
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "applicant")
class ApplicantEntity(
    override val memberId: EmbeddedMemberId,
    privacy: EmbeddedPrivacy?,
    education: EmbeddedEducation?
): BaseMemberIdEntity(memberId) {
    @Embedded
    var privacy = privacy
        protected set

    @Embedded
    var education = education
        protected set
}