package com.daegusw.apply.applicant.application.port.`in`.web

import com.daegusw.apply.applicant.application.common.dto.InformationDto
import com.daegusw.apply.member.id.MemberId

interface InformationUseCase {
    fun find(memberId: MemberId): InformationDto

    fun update(memberId: MemberId, information: InformationDto)
}