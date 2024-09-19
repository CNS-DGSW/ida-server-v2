package com.daegusw.apply.s3.adapter.common.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class AwsS3Properties(
    @Value("\${cloud.aws.s3.bucket:bucket}") val bucket: String
)