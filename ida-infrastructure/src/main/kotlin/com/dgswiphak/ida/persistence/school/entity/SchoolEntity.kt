package com.dgswiphak.ida.persistence.school.entity

import com.dgswiphak.ida.persistence.applicant.entity.value.SchoolCodeVO
import jakarta.persistence.*

@Entity
@Table(name = "school")
class SchoolEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    val name: String,

    val state: String,

    val city: String,

    @Embedded
    val code: SchoolCodeVO,

    val contact: String
)