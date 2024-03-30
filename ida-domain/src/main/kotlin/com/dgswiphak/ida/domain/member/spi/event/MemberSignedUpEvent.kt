package com.dgswiphak.ida.domain.member.spi.event

import com.dgswiphak.ida.common.model.MemberId

data class MemberSignedUpEvent(
    val memberId: MemberId
)