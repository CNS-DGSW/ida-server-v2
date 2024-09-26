package com.daegusw.apply.core.data.entity.member

import com.daegusw.apply.core.data.common.BaseMemberIdEntity
import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.member.domain.value.Password
import com.daegusw.apply.member.domain.value.Role
import javax.persistence.*

@Entity
@Table(name = "member")
class MemberEntity(
    override val memberId: EmbeddedMemberId,
    email: String,
    password: Password,
    role: Role
): BaseMemberIdEntity(memberId) {
    var email: String = email
        protected set

    var password: Password = password
        protected set

    @Enumerated(EnumType.STRING)
    var role: Role = role
        protected set
}