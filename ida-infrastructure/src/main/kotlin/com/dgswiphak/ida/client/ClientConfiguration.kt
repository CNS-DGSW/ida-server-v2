package com.dgswiphak.ida.client

import com.dgswiphak.ida.client.neis.NeisClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory

@Configuration
class ClientConfiguration(
    private val restClient: RestClient
) {
    @Bean
    fun neisClient(): NeisClient {
        val factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient))
        return factory.build().createClient(NeisClient::class.java)
    }
}