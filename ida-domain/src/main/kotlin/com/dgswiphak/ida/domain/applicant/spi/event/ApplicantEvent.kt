package com.dgswiphak.ida.domain.applicant.spi.event

import com.dgswiphak.ida.domain.member.event.MemberSignedUpEvent

interface ApplicantEvent {
    fun createApplicant(event: MemberSignedUpEvent)
}