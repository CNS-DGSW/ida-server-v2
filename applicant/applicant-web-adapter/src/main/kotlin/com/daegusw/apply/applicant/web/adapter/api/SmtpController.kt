package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.port.`in`.web.SmtpUseCase
import com.daegusw.apply.applicant.web.adapter.api.request.SmtpRequest
import com.daegusw.apply.applicant.web.adapter.api.response.SmtpResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotEmpty

@RestController
@RequestMapping("/applicant/stmp")
class SmtpController(
    private val smtpUseCase: SmtpUseCase
) {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    suspend fun send(@NotEmpty(message = "email is required")@RequestParam email: String) : SmtpResponse {
        return SmtpResponse(smtpUseCase.send(email) + "로 전송 완료")
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    suspend fun verify(@Valid @RequestBody smtpRequest: SmtpRequest) : SmtpResponse {
        return SmtpResponse(smtpUseCase.verify(smtpRequest.email,smtpRequest.code))
    }

}