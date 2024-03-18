package com.dgswiphak.ida.global.config

import com.dgswiphak.ida.domain.member.model.value.Role
import com.dgswiphak.ida.global.filter.FilterConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration(
    private val filterConfiguration: FilterConfiguration
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf().disable()
            .cors(Customizer.withDefaults())
            .formLogin().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.authorizeHttpRequests()
            .requestMatchers("/applicant/**").hasRole(Role.ROLE_APPLICANT.role)

            .requestMatchers(HttpMethod.POST,"/notice").hasRole(Role.ROLE_TEACHER.role)
            .requestMatchers(HttpMethod.PATCH,"/notice/{notice-id}").hasRole(Role.ROLE_TEACHER.role)
            .requestMatchers(HttpMethod.DELETE,"/notice/{notice-id}").hasRole(Role.ROLE_TEACHER.role)

            .requestMatchers(HttpMethod.PUT,"/image/save").hasRole(Role.ROLE_TEACHER.role)
            .requestMatchers(HttpMethod.DELETE,"/image/{image-name}").hasRole(Role.ROLE_TEACHER.role)

            .requestMatchers(HttpMethod.PUT,"/attached/{notice-id}").hasRole(Role.ROLE_TEACHER.role)
            .requestMatchers(HttpMethod.DELETE,"/attached/{notice-id}/{file-name}").hasRole(Role.ROLE_TEACHER.role)
            .anyRequest().permitAll()

        http
            .apply(filterConfiguration)
        return http.build()
    }
}