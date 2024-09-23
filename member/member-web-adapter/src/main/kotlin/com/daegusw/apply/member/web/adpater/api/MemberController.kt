package com.daegusw.apply.member.web.adpater.api

import com.daegusw.apply.member.web.adpater.api.request.SignupMemberRequest
import com.daegusw.apply.memnber.application.port.`in`.web.SignupApplicantUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(
    private val signupApplicantUseCase: SignupApplicantUseCase
) {
    @PostMapping("/signup-applicant")
    @ResponseStatus(HttpStatus.CREATED)
    fun applicantSignup(
        @RequestBody request: SignupMemberRequest
    ) {
        signupApplicantUseCase.signupApplicant(request.toCommand())
    }
}