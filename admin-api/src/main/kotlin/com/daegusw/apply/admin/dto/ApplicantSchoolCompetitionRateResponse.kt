package com.daegusw.apply.admin.dto

data class ApplicantSchoolCompetitionRateResponse(
    val apply: String,
    var graduatedMale: Int = 0,
    var graduatedFemale: Int = 0,
    var expectedMale: Int = 0,
    var expectedFemale: Int = 0,
    var otherCityMale: Int = 0,
    var otherCityFemale: Int = 0,
    var gedMale: Int = 0,
    var gedFemale: Int = 0,
    var totalMale: Int = 0,
    var totalFemale: Int = 0,
    var total: Int = 0
)