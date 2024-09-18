package com.daegusw.apply.applicant.application.port.out.client

import com.daegusw.apply.applicant.application.common.dto.SchoolResponse

interface SchoolSearchWebClientPort {
    fun search(q: String): List<SchoolResponse>
}