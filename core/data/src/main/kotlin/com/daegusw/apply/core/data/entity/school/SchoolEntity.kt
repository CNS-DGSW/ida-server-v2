package com.daegusw.apply.core.data.entity.school

import com.daegusw.apply.core.data.entity.applicant.value.TeacherVO
import javax.persistence.*

@Entity
@Table(name = "school")
class SchoolEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    teacher: TeacherVO,
    name: String,
    state: String,
    city: String,
    code: String,
    contact: String,
    graduateYear: Short
) {
    @Embedded
    var teacher: TeacherVO = teacher
        protected set

    var name: String = name
        protected set

    var state: String = state
        protected set

    var city: String = city
        protected set

    var code: String = code
        protected set

    var contact: String = contact
        protected set

    var graduateYear: Short = graduateYear
        protected set
}