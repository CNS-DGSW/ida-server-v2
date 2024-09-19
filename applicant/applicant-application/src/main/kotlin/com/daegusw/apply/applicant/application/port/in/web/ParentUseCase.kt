package com.daegusw.apply.applicant.application.port.`in`.web

import com.daegusw.apply.applicant.application.common.dto.ParentDto
import com.daegusw.apply.member.id.MemberId

interface ParentUseCase {
    fun find(memberId: MemberId): ParentDto

    fun update(memberId: MemberId, dto: ParentDto)
}