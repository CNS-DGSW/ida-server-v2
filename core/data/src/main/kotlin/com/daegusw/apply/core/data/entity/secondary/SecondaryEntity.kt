package com.daegusw.apply.core.data.entity.secondary

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.entity.secondary.value.AptitudeVO
import com.daegusw.apply.core.data.entity.secondary.value.InterviewVO
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "secondary")
class SecondaryEntity(

    @EmbeddedId
    val id: EmbeddedMemberId,

    @Embedded
    val aptitudeVO: AptitudeVO,

    @Embedded
    val interviewVO: InterviewVO

)