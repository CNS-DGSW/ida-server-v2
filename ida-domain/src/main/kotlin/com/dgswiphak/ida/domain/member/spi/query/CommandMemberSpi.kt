package com.dgswiphak.ida.domain.member.spi.query

import com.dgswiphak.ida.domain.member.model.Member

interface CommandMemberSpi {
    fun save(member: Member): Member
}