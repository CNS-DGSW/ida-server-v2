package com.daegusw.apply.applicant.application.port.`in`.web

import com.daegusw.apply.applicant.application.common.dto.SchoolResponse

interface SchoolUseCase {
    fun search(q: String): List<SchoolResponse>
}