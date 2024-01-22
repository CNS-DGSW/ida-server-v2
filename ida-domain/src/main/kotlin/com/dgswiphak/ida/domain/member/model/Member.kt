package com.dgswiphak.ida.domain.member.model

import com.dgswiphak.ida.common.identity.MemberId
import com.dgswiphak.ida.domain.member.model.value.Password
import com.dgswiphak.ida.domain.member.model.value.Role

data class Member(
        val id: MemberId,
        val email: String,
        val password: Password,
        val role: Role
)