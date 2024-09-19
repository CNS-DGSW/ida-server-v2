package com.daegusw.apply.security

import com.daegusw.apply.member.id.MemberId
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthUser(
    val id: MemberId,
    private val email: String,
    private val password: String,
    private val authority: MutableCollection<out GrantedAuthority>
): UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> =
        authority

    override fun getPassword(): String = password

    override fun getUsername(): String = id.toString()

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}