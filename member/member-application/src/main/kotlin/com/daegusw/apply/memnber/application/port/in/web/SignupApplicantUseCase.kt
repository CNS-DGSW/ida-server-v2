package com.daegusw.apply.memnber.application.port.`in`.web

import com.daegusw.apply.memnber.application.common.MemberCommand

interface SignupApplicantUseCase {
    fun signupApplicant(memberCommand: MemberCommand)
}