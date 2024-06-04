package com.dgswiphak.ida.domain.school.model

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.common.model.SchoolCode

class School(
    id: Long? = 0,
    name: String,
    state: String,
    city: String,
    code: SchoolCode,
    contact: PhoneNumber,
) {
    val id = id
    val name = name
    val state = state
    val city = city
    val code = code
    val contact = contact
}
