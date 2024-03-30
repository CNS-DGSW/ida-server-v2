package com.dgswiphak.ida.domain.applicant.spi.event

import com.dgswiphak.ida.domain.member.spi.event.MemberSignedUpEvent

interface ApplicantEventPublisher {
    fun createApplicant(event: MemberSignedUpEvent)
}