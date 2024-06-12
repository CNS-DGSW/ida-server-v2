package com.dgswiphak.ida.domain.admin.dto

data class UserSchoolCityInfoResponse(
    val index: Int,
    val city: String,
    val schoolName: String,
    var graduatedMale: Int = 0,
    var graduatedFemale: Int = 0,
    var expectedMale: Int = 0,
    var expectedFemale: Int = 0,
    var male: Int = 0,
    var female: Int = 0,
    var total: Int = 0
)