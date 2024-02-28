package com.dgswiphak.ida.common.config

import com.dgswiphak.ida.common.property.JwtProperties
import com.dgswiphak.ida.common.property.NeisProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(
    basePackageClasses = [
        NeisProperties::class,
        JwtProperties::class
    ]
)

@Configuration
class PropertiesScanConfiguration