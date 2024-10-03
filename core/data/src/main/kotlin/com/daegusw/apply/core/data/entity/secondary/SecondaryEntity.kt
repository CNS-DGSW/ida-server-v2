package com.daegusw.apply.core.data.entity.secondary

import com.daegusw.apply.core.data.entity.secondary.value.AptitudeVO
import com.daegusw.apply.core.data.entity.secondary.value.ExamineeVO
import com.daegusw.apply.core.data.entity.secondary.value.InterviewVO
import javax.persistence.*

@Entity
@Table(name = "secondary")
class SecondaryEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    examinee: ExamineeVO,
    aptitude: AptitudeVO,
    interview: InterviewVO
) {
    @Embedded
    var examinee: ExamineeVO = examinee
        protected set

    @Embedded
    var aptitude: AptitudeVO = aptitude
        protected set

    @Embedded
    var interview: InterviewVO = interview
        protected set
}