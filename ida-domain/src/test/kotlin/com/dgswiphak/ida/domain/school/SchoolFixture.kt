package com.dgswiphak.ida.domain.school

import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.common.model.SchoolCode
import com.dgswiphak.ida.domain.school.model.School

internal fun createSchool(
    name: String = "대구소프트웨어마이스터고등학교",
    state: String = "대구광역시",
    city: String = "달성군",
    code: SchoolCode = SchoolCode("0000000"),
    contact: PhoneNumber = PhoneNumber("01012345678")
): School = School(
    name = name,
    state = state,
    city = city,
    code = code,
    contact = contact
)