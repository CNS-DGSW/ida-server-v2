package com.daegusw.apply.notice.s3.adapter.common.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class NoticeAwsS3Properties(
    @Value("\${cloud.aws.s3.bucket:bucket}") val bucket: String
)