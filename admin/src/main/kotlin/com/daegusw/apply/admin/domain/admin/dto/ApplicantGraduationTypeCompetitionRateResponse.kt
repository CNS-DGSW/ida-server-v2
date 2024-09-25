package com.daegusw.apply.admin.domain.admin.dto

data class ApplicantGraduationTypeCompetitionRateResponse(
    var graduatedMale: Int = 0,
    var graduatedFemale: Int = 0,
    var expectedMale: Int = 0,
    var expectedFemale: Int = 0,
    var gedMale: Int = 0,
    var gedFemale: Int = 0,
    var male: Int = 0,
    var female: Int = 0,
    var total: Int = 0
)
