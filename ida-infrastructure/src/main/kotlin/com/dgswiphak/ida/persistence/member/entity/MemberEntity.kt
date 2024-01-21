package com.dgswiphak.ida.persistence.member.entity

import com.dgswiphak.ida.domain.member.model.value.Password
import com.dgswiphak.ida.domain.member.model.value.Role
import com.dgswiphak.ida.common.convert.PasswordConverter
import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import jakarta.persistence.*

@Entity
@Table(name = "member")
class MemberEntity (
   @EmbeddedId
   val id: EmbeddedMemberId,

   val email: String,

   @Convert(converter = PasswordConverter::class)
   val password: Password,

   @Enumerated(EnumType.STRING)
   val role: Role
)