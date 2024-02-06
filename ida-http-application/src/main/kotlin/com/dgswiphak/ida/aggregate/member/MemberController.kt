package com.dgswiphak.ida.aggregate.member

import com.dgswiphak.ida.domain.member.dto.SingUpMemberRequest
import com.dgswiphak.ida.domain.member.usecase.SingUpMemberUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(
    private val signUpMemberUseCase: SingUpMemberUseCase
) {
    @PostMapping("/signUp")
    @ResponseStatus(HttpStatus.CREATED)
    fun sighUpMember(
        @RequestBody request: SingUpMemberRequest
    ) {
        signUpMemberUseCase.execute(request)
    }
}