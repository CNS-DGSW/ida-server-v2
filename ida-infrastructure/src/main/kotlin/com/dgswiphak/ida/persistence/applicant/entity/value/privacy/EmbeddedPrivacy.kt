package com.dgswiphak.ida.persistence.applicant.entity.value.privacy

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.common.model.Photo
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.AddressVO
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.MeritVO
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.ParentVO
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.SchoolCodeVO
import jakarta.persistence.*
import java.time.LocalDate

@Embeddable
data class EmbeddedPrivacy(
    @Column
    val name: String?,

    @Column
    val birth: LocalDate?,

    @Column
    @Enumerated(EnumType.STRING)
    val gender: Gender?,

    @Column
    val phone: PhoneNumber?,

    @Column
    val photo: Photo?,

    @Column
    @Embedded
    val schoolCode: SchoolCodeVO?,

    @Column
    @Embedded
    val address: AddressVO?,

    @Column
    @Embedded
    val parent: ParentVO?,

    @Column
    @Embedded
    val merit: MeritVO?
)