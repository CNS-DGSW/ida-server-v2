package com.dgswiphak.ida.domain.secondary.spi.event

import com.dgswiphak.ida.domain.member.event.MemberSignedUpEvent

interface SecondaryEvent {
    fun createSecondary(event: MemberSignedUpEvent)
}