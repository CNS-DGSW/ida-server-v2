package com.dgswiphak.ida.common.config.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("cloud.aws.s3")
class AwsS3Properties(
    val bucket: String
)