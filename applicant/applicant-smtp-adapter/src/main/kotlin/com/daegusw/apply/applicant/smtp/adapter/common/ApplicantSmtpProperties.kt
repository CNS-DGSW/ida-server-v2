package com.daegusw.apply.applicant.smtp.adapter.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class ApplicantSmtpProperties (
    @Value("\${cloud.aws.credentials.access-key:access-key}") val accessKey : String,
    @Value("\${cloud.aws.credentials.secret-key:secret-key}") val secretKey : String,
    @Value("\${cloud.aws.credentials.send-mail-to:send-mail-to}") val sendEmailTo : String,
    @Value("\${cloud.aws.region:region}") val region : String,
)