package com.daegusw.apply.core.data.entity.school

import javax.persistence.*

@Entity
@Table(name = "school")
class SchoolEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    name: String,
    state: String,
    city: String,
    code: String,
    contact: String
) {
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
}