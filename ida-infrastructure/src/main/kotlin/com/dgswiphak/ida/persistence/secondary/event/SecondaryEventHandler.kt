package com.dgswiphak.ida.persistence.secondary.event

import com.dgswiphak.ida.domain.member.event.MemberSignedUpEvent
import com.dgswiphak.ida.domain.secondary.model.Secondary
import com.dgswiphak.ida.domain.secondary.model.value.Aptitude
import com.dgswiphak.ida.domain.secondary.model.value.Interview
import com.dgswiphak.ida.domain.secondary.spi.event.SecondaryEvent
import com.dgswiphak.ida.domain.secondary.spi.query.CommandSecondarySpi
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class SecondaryEventHandler(
    private val commandSecondarySpi: CommandSecondarySpi
): SecondaryEvent {

    @EventListener
    override fun createSecondary(event: MemberSignedUpEvent) {
        commandSecondarySpi.save(
            Secondary(
                id = event.memberId,
                Aptitude(),
                Interview()
            )
        )
    }
}