package com.dgswiphak.ida.persistence.applicant.entity

import com.dgswiphak.ida.common.convert.PhoneNumberConvert
import com.dgswiphak.ida.common.convert.PhotoConverter
import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.Photo
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.type.Gender
import com.dgswiphak.ida.persistence.applicant.entity.value.AddressVO
import com.dgswiphak.ida.persistence.applicant.entity.value.MeritVO
import com.dgswiphak.ida.persistence.applicant.entity.value.ParentVO
import com.dgswiphak.ida.persistence.applicant.entity.value.SchoolCodeVO
import jakarta.persistence.*
import java.io.Serial
import java.io.Serializable
import java.time.LocalDate

@Embeddable
class EmbeddedPrivacy(
    val name: String?,
    val birth: LocalDate?,
    @Enumerated(EnumType.STRING)
    val gender: Gender?,
    @Convert(converter = PhoneNumberConvert::class)
    val phone: PhoneNumber?,
    @Convert(converter = PhotoConverter::class)
    val photo: Photo?,
    @Embedded
    val school: SchoolCodeVO?,
    @Embedded
    val address: AddressVO?,
    @Embedded
    val parent: ParentVO?,
    @Embedded
    val merit: MeritVO?,
): Serializable {
    companion object {
        @Serial
        private const val serialVersionUID: Long = -4349377963218637774L
    }
}