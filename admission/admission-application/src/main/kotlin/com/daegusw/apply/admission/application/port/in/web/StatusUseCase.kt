package com.daegusw.apply.admission.application.port.`in`.web

import com.daegusw.apply.admission.application.common.dto.StatusDto
import com.daegusw.apply.member.id.MemberId

interface StatusUseCase {
    fun find(id: MemberId): StatusDto
}