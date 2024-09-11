package com.daegusw.apply.s3.adapter.common.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class AwsProperties (
    @Value("\${aws.credentials.accessKey:accessKey}") val accessKey : String,
    @Value("\${aws.credentials.secretKey:secretKey}") val secretKey : String
)