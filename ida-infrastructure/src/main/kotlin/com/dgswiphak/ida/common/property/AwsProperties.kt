package com.dgswiphak.ida.common.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws.credentials")
class AwsProperties (
    val accessKey : String,
    val secretKey : String
)