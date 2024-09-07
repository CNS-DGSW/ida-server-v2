package com.daegusw.apply.core.data.entity

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.common.TimeBaseEntity
import com.daegusw.apply.member.domain.value.Password
import com.daegusw.apply.member.domain.value.Role
import javax.persistence.*

@Entity
@Table(name = "member")
class MemberEntity(
    @EmbeddedId
    val id: EmbeddedMemberId,
    email: String,
    password: Password,
    role: Role
) : TimeBaseEntity(){
    var email: String = email
        protected set

    var password: Password = password
        protected set

    @Enumerated(EnumType.STRING)
    var role: Role = role
        protected set
}