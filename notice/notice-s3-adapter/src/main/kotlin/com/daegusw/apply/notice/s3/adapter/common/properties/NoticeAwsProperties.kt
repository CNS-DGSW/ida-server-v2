package com.daegusw.apply.notice.s3.adapter.common.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class NoticeAwsProperties (
    @Value("\${cloud.aws.credentials.access-key:access-key}") val accessKey : String,
    @Value("\${cloud.aws.credentials.secret-key:secret-key}") val secretKey : String
)