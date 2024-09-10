package com.daegusw.apply.s3.adapter.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws.credentials")
class AwsProperties (
    val accessKey : String,
    val secretKey : String
)