package com.daegusw.apply.admission.application.port.`in`.web

import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.daegusw.apply.member.id.MemberId

interface ApplyTypeUseCase {
    fun find(id: MemberId): ApplyType

    fun update(id: MemberId, type: ApplyType)
}