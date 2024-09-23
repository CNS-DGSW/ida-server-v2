package com.daegusw.apply.applicant.domain.applicant.privacy

import com.daegusw.apply.applicant.domain.applicant.privacy.constant.Gender
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Address
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Merit
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Parent
import java.time.LocalDate

data class Privacy(
    var name: String,
    var birth: LocalDate,
    var gender: Gender,
    var phone: String,
    var photo: String,
    var address: Address?,
    var parent: Parent?,
    var merit: Merit?,
) {
    fun updateInformation(name: String, birth: LocalDate, gender: Gender, phone: String) {
        this.name = name
        this.birth = birth
        this.gender = gender
        this.phone = phone
    }

    fun updateParent(parent: Parent) {
        this.parent = parent
    }

    fun updateAddress(address: Address) {
        this.address = address
    }

    fun updatePhoto(filename: String) {
        this.photo = filename
    }
}