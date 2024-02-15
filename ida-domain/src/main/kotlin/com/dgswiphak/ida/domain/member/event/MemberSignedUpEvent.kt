package com.dgswiphak.ida.domain.member.event

import com.dgswiphak.ida.common.model.MemberId

data class MemberSignedUpEvent(
    val memberId: MemberId
)