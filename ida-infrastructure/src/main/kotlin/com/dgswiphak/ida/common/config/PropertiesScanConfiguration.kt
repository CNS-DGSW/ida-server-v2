package com.dgswiphak.ida.common.config

import com.dgswiphak.ida.common.property.AwsProperties
import com.dgswiphak.ida.common.property.AwsS3Properties
import com.dgswiphak.ida.common.property.JwtProperties
import com.dgswiphak.ida.common.property.NeisProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(
    basePackageClasses = [
        NeisProperties::class,
        JwtProperties::class,
        AwsProperties::class,
        AwsS3Properties::class
    ]
)

@Configuration
class PropertiesScanConfiguration