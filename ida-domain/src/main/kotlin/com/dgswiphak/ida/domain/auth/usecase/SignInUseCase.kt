package com.dgswiphak.ida.domain.auth.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.util.PasswordUtil
import com.dgswiphak.ida.domain.auth.dto.SignInRequest
import com.dgswiphak.ida.domain.auth.dto.SignInResponse
import com.dgswiphak.ida.domain.auth.spi.service.TokenService
import com.dgswiphak.ida.domain.member.spi.query.QueryMemberSpi

@UseCase
class SignInUseCase(
    private val queryMemberSpi: QueryMemberSpi,
    private val tokenService: TokenService,
    private val passwordUtil: PasswordUtil
) {
    fun execute(request: SignInRequest): SignInResponse {
        val member = queryMemberSpi.findByEmail(request.email) ?: throw RuntimeException()
        if (!passwordUtil.matches(request.password, member.password.value)) {
            throw RuntimeException()
        }

        return SignInResponse(
            tokenService.generateAccessToken(member.id.value),
            tokenService.generateRefreshToken(member.id.value)
        )
    }
}