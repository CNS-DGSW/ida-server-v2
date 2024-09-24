package com.daegusw.apply.memnber.application.service

import com.daegusw.apply.applicant.application.port.out.persistence.CommandApplicantPort
import com.daegusw.apply.applicant.application.port.out.redis.RedisPort
import com.daegusw.apply.applicant.domain.applicant.Applicant
import com.daegusw.apply.core.hash.Sha512Encoder
import com.daegusw.apply.core.idgen.IdGenerator
import com.daegusw.apply.member.domain.Member
import com.daegusw.apply.member.domain.value.Password
import com.daegusw.apply.member.domain.value.Role
import com.daegusw.apply.member.id.MemberId
import com.daegusw.apply.memnber.application.common.MemberCommand
import com.daegusw.apply.memnber.application.exception.DuplicateEmailException
import com.daegusw.apply.memnber.application.port.`in`.web.SignupApplicantUseCase
import com.daegusw.apply.memnber.application.port.out.persistence.CommandMemberPort
import com.daegusw.apply.memnber.application.port.out.persistence.QueryMemberPort
import org.springframework.stereotype.Service

@Service
class SignupApplicantService(
    private val queryMemberPort: QueryMemberPort,
    private val commandMemberPort: CommandMemberPort,
    private val commandApplicantPort: CommandApplicantPort,
    private val sha512Encoder: Sha512Encoder,
    private val redisPort: RedisPort
) : SignupApplicantUseCase {
    override fun signupApplicant(memberCommand: MemberCommand) {
        if (queryMemberPort.existsByEmail(memberCommand.email)) {
            throw DuplicateEmailException(memberCommand.email)
        }
        if (redisPort.get(memberCommand.email) == "verified"){
            commandMemberPort.saveMember(
                Member(
                    id = MemberId(IdGenerator.generateUUIDWithLong()),
                    email = memberCommand.email,
                    password = Password(sha512Encoder.encode(memberCommand.password)),
                    role = Role.ROLE_APPLICANT
                )
            ).also { commandApplicantPort.save(Applicant(it.id)) }
        }
        else{
            throw RuntimeException("Unauthorized Email")
        }
    }
}