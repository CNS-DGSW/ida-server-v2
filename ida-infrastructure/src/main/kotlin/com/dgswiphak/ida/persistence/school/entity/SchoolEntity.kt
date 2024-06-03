package com.dgswiphak.ida.persistence.school.entity

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.SchoolCodeVO
import jakarta.persistence.*

@Entity
@Table(name = "school")
class SchoolEntity(
    id: Long,
    name: String,
    state: String,
    city: String,
    code: SchoolCodeVO,
    contact: PhoneNumber
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = id

    var name: String = name
        protected set

    var state: String = state
        protected set

    var city: String = city
        protected set

    @Embedded
    var code: SchoolCodeVO = code
        protected set

    var contact: PhoneNumber = contact
        protected set
}