package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.port.`in`.web.SmtpUseCase
import com.daegusw.apply.applicant.web.adapter.api.request.SmtpRequest
import kotlinx.coroutines.runBlocking
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/applicant/stmp")
class SmtpController(
    private val smtpUseCase: SmtpUseCase
) {
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    fun send(@RequestParam email: String) : String {
        return runBlocking {
            smtpUseCase.send(email)
            "전송 완료"
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    fun verify(@RequestBody smtpRequest: SmtpRequest) : String{
        return runBlocking {
            smtpUseCase.verify(smtpRequest.email,smtpRequest.code)
        }
    }

}