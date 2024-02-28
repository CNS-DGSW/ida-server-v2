package com.dgswiphak.ida.global.auth.annotation

import org.springframework.security.core.annotation.AuthenticationPrincipal

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.VALUE_PARAMETER)
@AuthenticationPrincipal(expression = "#this == 'anonymousUser' ? -1 : #this.id")
annotation class AuthenticatedPrincipalId
