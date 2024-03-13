package com.dgswiphak.ida.common.property

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "neis")
class NeisProperties(
    val key: String
)