package com.daegusw.apply.applicant.application.port.`in`.web

import com.daegusw.apply.applicant.domain.applicant.education.constant.GraduationType
import com.daegusw.apply.member.id.MemberId

interface EducationUseCase {
    fun find(memberId: MemberId): GraduationType

    fun update(memberId: MemberId, graduationType: GraduationType)
}