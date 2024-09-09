package com.daegusw.apply.auth.application.service

import com.daegusw.apply.auth.application.LoginMember
import com.daegusw.apply.auth.application.TokenDto
import com.daegusw.apply.auth.application.common.dto.Payload
import com.daegusw.apply.auth.application.common.utils.JwtUtils
import com.daegusw.apply.auth.application.port.`in`.web.LoginUseCase
import com.daegusw.apply.core.hash.Sha512Encoder
import com.daegusw.apply.memnber.application.port.out.persistence.QueryMemberPort
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val queryMemberPort: QueryMemberPort,
    private val sha512Encoder: Sha512Encoder,
    private val jwtUtils: JwtUtils
) : LoginUseCase {
    override fun login(loginMember: LoginMember): TokenDto {
        val member = queryMemberPort.findByEmail(loginMember.email) ?: throw RuntimeException()

        if (!sha512Encoder.matches(loginMember.password, member.password.value)) {
            throw RuntimeException()
        }

        val payload: MutableSet<Payload> = HashSet()
        payload.add(Payload("memberId", member.id.value.toString()))

        return TokenDto(
            jwtUtils.createAccessToken(payload)
        )
    }
}