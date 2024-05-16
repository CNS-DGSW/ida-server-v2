package com.dgswiphak.ida.global.filter

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.global.error.ErrorResponse
import com.dgswiphak.ida.global.error.InternationalServerException
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
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
            setErrorResponse(e, response)
        } catch (e: Exception) {
            when(e.cause) {
                is IdaException -> {
                    e.printStackTrace()
                    setErrorResponse(e.cause as IdaException, response)
                }
                else -> {
                    e.printStackTrace()
                    setErrorResponse(InternationalServerException, response)
                }
            }
        }
    }

    private fun setErrorResponse(exception: IdaException, response: HttpServletResponse) {
        response.status = exception.errorProperty.status()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.characterEncoding = StandardCharsets.UTF_8.name()
        response.writer.write(
            objectMapper.writeValueAsString(
                ErrorResponse.of(exception.errorProperty)
            )
        )
    }

}