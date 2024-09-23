package com.daegusw.apply.admission.application.port.`in`.web

import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.member.id.MemberId

interface ProgressUseCase {
    fun find(id: MemberId): Progress
}