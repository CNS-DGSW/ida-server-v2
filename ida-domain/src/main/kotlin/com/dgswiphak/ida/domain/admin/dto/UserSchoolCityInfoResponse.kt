package com.dgswiphak.ida.domain.admin.dto

data class UserSchoolCityInfoResponse(
    val index: Long,
    val city: String,
    val schoolName: String,
    var graduatedMale: Int = 0,
    var graduatedFemale: Int = 0,
    var expectedMale: Int = 0,
    var expectedFemale: Int = 0
)