package com.dgswiphak.ida.domain.member.usecase

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.util.IdGenerator
import com.dgswiphak.ida.common.util.PasswordUtil
import com.dgswiphak.ida.domain.member.dto.SingUpMemberRequest
import com.dgswiphak.ida.domain.applicant.spi.event.ApplicantEventPublisher
import com.dgswiphak.ida.domain.member.spi.event.MemberSignedUpEvent
import com.dgswiphak.ida.domain.member.model.Member
import com.dgswiphak.ida.domain.member.model.value.Password
import com.dgswiphak.ida.domain.member.model.value.Role
import com.dgswiphak.ida.domain.member.spi.query.CommandMemberSpi
import com.dgswiphak.ida.domain.member.spi.query.QueryMemberSpi

@UseCase
class SingUpMemberUseCase(
    private val queryMemberSpi: QueryMemberSpi,
    private val commandMemberSpi: CommandMemberSpi,
    private val passwordUtil: PasswordUtil,
    private val applicantEventPublisher: ApplicantEventPublisher
) {
    fun execute(request: SingUpMemberRequest) {
        if (queryMemberSpi.existByEmail(request.email)) {
            throw RuntimeException("exist email exception")
        }

        commandMemberSpi.save(
                Member(
                        id =  MemberId(IdGenerator.generateUUIDWithLong()),
                        email = request.email,
                        password = Password(passwordUtil.encoded(request.password)),
                        role = Role.ROLE_APPLICANT
                )
        ).also {
            applicantEventPublisher.createApplicant(MemberSignedUpEvent(it.id))
        }
    }
}