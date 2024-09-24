package com.daegusw.apply.applicant.application.port.`in`.web

import com.daegusw.apply.applicant.application.common.dto.SchoolDto
import com.daegusw.apply.applicant.application.common.dto.SchoolResponse
import com.daegusw.apply.member.id.MemberId

interface SchoolUseCase {
    fun find(id: MemberId): SchoolDto
    fun update(id: MemberId, dto: SchoolDto)

    fun search(q: String): List<SchoolResponse>
}