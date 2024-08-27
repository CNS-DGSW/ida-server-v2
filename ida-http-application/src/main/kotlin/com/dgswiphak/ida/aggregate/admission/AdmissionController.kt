package com.dgswiphak.ida.aggregate.admission

import com.dgswiphak.ida.domain.admission.admission.dto.ApplyTypeResponse
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.admission.admission.dto.ApplyTypeRequest
import com.dgswiphak.ida.domain.admission.admission.dto.DocumentDto
import com.dgswiphak.ida.domain.admission.admission.usecase.AdmissionUseCase
import com.dgswiphak.ida.global.auth.annotation.AuthenticatedPrincipalId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admission")
class AdmissionController(
    private val admissionUseCase: AdmissionUseCase

) {
    @GetMapping("/type")
    @ResponseStatus(HttpStatus.OK)
    fun findType(
        @AuthenticatedPrincipalId id: MemberId
    ): ApplyTypeResponse {
        return admissionUseCase.findType(id)
    }

    @PutMapping("/type")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateType(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: ApplyTypeRequest
    ) {
        admissionUseCase.updateType(id, request)
    }

    @GetMapping("/document")
    @ResponseStatus(HttpStatus.OK)
    fun findDocument(
        @AuthenticatedPrincipalId id: MemberId,
    ): DocumentDto {
        return admissionUseCase.findDocument(id)
    }

    @PutMapping("/document")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateDocument(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: DocumentDto
    ) {
        return admissionUseCase.updateDocument(id, request)
    }
}
