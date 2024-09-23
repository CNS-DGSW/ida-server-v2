package com.daegusw.apply.admission.application.port.`in`.web

import com.daegusw.apply.admission.application.common.dto.DocumentDto
import com.daegusw.apply.member.id.MemberId

interface DocumentUseCase {
    fun find(id: MemberId): DocumentDto
    fun update(id: MemberId, documentDto: DocumentDto)
}