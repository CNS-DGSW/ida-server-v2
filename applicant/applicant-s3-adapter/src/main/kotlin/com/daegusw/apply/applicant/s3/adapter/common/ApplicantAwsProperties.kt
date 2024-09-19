package com.daegusw.apply.applicant.s3.adapter.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class ApplicantAwsProperties (
    @Value("\${cloud.aws.credentials.access-key:access-key}") val accessKey : String,
    @Value("\${cloud.aws.credentials.secret-key:secret-key}") val secretKey : String
)