package com.dgswiphak.ida.domain.applicant.model.value.privacy

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.common.model.Photo
import com.dgswiphak.ida.common.model.SchoolCode
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.*
import java.time.LocalDate

data class Privacy(
    val name: String? = null,
    val birth: LocalDate? = null,
    val gender: Gender? = null,
    var phone: PhoneNumber? = null,
    var photo: Photo? = null,
    var schoolCode: SchoolCode? = null,
    var address: Address? = null,
    var parent: Parent? = null,
    var merit: Merit? = null
) {

    fun updateParentInfo(parent: Parent) {
        this.parent = parent
    }

    fun updateAddress(address: Address) {
        this.address = address
    }

    fun updatePhoto(filename: Photo) {
        this.photo = filename
    }
}