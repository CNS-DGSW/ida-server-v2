package com.daegusw.apply.core.data.entity

import com.daegusw.apply.core.data.common.EmbeddedMemberId
import com.daegusw.apply.core.data.common.TimeBaseEntity
import com.daegusw.apply.member.domain.value.Password
import com.daegusw.apply.member.domain.value.Role
import org.springframework.data.domain.Persistable
import javax.persistence.*

@Entity
@Table(name = "member")
class MemberEntity(
    @EmbeddedId
    val memberId: EmbeddedMemberId,
    email: String,
    password: Password,
    role: Role
) : TimeBaseEntity(), Persistable<EmbeddedMemberId>{
    var email: String = email
        protected set

    var password: Password = password
        protected set

    @Enumerated(EnumType.STRING)
    var role: Role = role
        protected set

    override fun getId(): EmbeddedMemberId = memberId

    @Transient
    private var _isNew = true

    override fun isNew(): Boolean = _isNew

    @PostPersist
    @PostLoad
    protected fun load() {
        _isNew = false
    }
}