package com.daegusw.apply.s3.adapter.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws.s3")
class AwsS3Properties(
    val bucket: String
)