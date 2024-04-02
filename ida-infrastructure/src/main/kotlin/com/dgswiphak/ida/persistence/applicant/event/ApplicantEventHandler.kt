package com.dgswiphak.ida.persistence.applicant.event

import com.dgswiphak.ida.domain.applicant.domain.Applicant
import com.dgswiphak.ida.domain.applicant.domain.value.education.Education
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.Privacy
import com.dgswiphak.ida.domain.applicant.spi.event.ApplicantEventPublisher
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.domain.member.spi.event.MemberSignedUpEvent
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class ApplicantEventHandler(
    private val commandApplicantSpi: CommandApplicantSpi
): ApplicantEventPublisher {
    @EventListener
    override fun createApplicant(event: MemberSignedUpEvent) {
        commandApplicantSpi.save(
            Applicant(
                id = event.memberId,
                privacy = Privacy(),
                education = Education()
            )
        )
    }
}