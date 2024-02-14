package com.dgswiphak.ida.persistence.applicant.entity.value

import com.dgswiphak.ida.common.convert.PhoneNumberConvert
import com.dgswiphak.ida.common.model.PhoneNumber
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable
import java.time.LocalDate

@Embeddable
class ParentVO(
    @Column(name = "parent_name")
    val name: String,

    @Column(name = "parent_relation")
    val relation: String,

    @Column(name = "parent_phone")
    @Convert(converter = PhoneNumberConvert::class)
    val phoneNumber: PhoneNumber,

    @Column(name = "parent_birth")
    val brith: LocalDate
): Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -4342377963213237774L
    }
}