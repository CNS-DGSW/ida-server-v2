package com.dgswiphak.ida.common.config

import com.dgswiphak.ida.common.property.JwtProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(
    basePackageClasses = [
        JwtProperties::class,
    ]
)

@Configuration
class PropertiesScanConfiguration