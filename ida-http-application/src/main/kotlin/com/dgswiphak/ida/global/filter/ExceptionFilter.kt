package com.dgswiphak.ida.global.filter

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.common.error.ErrorProperty
import com.dgswiphak.ida.global.error.ErrorResponse
import com.dgswiphak.ida.global.error.GlobalErrorCode
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets

@Component
class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter(){
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: IdaException) {
            e.printStackTrace()

            when(e.cause) {
                is IdaException -> {
                    setErrorResponse((e.cause as IdaException).errorProperty, response)
                }
                else -> {
                    setErrorResponse(GlobalErrorCode.INTERNATIONAL_SERVER_ERROR, response)
                }
            }
        }
    }

    private fun setErrorResponse(errorProperty: ErrorProperty, response: HttpServletResponse) {
        response.status = errorProperty.status();
        response.contentType = MediaType.APPLICATION_JSON_VALUE;
        response.characterEncoding = StandardCharsets.UTF_8.name();
        response.writer.write(
            objectMapper.writeValueAsString(
                ErrorResponse.of(errorProperty)
            )
        );
    }

}