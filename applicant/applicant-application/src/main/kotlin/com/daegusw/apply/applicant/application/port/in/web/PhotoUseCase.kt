package com.daegusw.apply.applicant.application.port.`in`.web

import com.daegusw.apply.member.id.MemberId
import java.io.File

interface PhotoUseCase {
    fun find(memberId: MemberId): String?
    fun update(memberId: MemberId, file: File)
}