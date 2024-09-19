package com.daegusw.apply.applicant.s3.adapter.common

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component

@Component
@PropertySource("classpath:application.yml")
class ApplicantAwsS3Properties(
    @Value("\${cloud.aws.s3.bucket:bucket}") val bucket: String
)