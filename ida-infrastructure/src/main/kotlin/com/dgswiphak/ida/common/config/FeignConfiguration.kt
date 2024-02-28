package com.dgswiphak.ida.common.config

import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration

@EnableFeignClients(
    basePackages = ["com.dgswiphak.ida"],
)
@Configuration
class FeignConfiguration