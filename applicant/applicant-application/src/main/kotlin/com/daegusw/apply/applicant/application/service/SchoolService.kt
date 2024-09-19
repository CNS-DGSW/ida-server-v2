package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.common.dto.SchoolResponse
import com.daegusw.apply.applicant.application.port.`in`.web.SchoolUseCase
import com.daegusw.apply.applicant.application.port.out.client.SchoolSearchWebClientPort
import org.springframework.stereotype.Service

@Service
class SchoolService(
    private val schoolSearchWebClientPort: SchoolSearchWebClientPort
) : SchoolUseCase {
    override fun search(q: String): List<SchoolResponse> {
        return schoolSearchWebClientPort.search(q)
    }
}