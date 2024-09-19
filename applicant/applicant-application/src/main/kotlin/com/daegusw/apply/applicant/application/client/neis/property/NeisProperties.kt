package com.daegusw.apply.applicant.application.client.neis.property

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class NeisProperties(
    @Value("\${neis.key}") val key: String,
)