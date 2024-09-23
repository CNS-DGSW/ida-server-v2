package com.daegusw.apply.api.security

import com.daegusw.apply.api.security.exception.CustomErrorCode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.http.HttpServletResponse

@Component
class ErrorResponseSender (
    private val objectMapper: ObjectMapper
) {

    fun send(response: HttpServletResponse, code: CustomErrorCode) {
        try {
            response.status = code.status.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.characterEncoding = "UTF-8"
            response.writer.write(objectMapper.writeValueAsString(BaseErrorResponse(code)))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}
