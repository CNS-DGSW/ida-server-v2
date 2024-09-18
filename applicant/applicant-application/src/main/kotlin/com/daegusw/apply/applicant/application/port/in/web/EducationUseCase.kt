package com.daegusw.apply.applicant.application.port.`in`.web

import com.daegusw.apply.applicant.application.common.dto.EducationDto
import com.daegusw.apply.member.id.MemberId

interface EducationUseCase {
    fun find(memberId: MemberId): EducationDto

    fun update(memberId: MemberId, education: EducationDto)
}