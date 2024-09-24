package com.daegusw.apply.admission.web.adapter.api

import com.daegusw.apply.admission.application.port.`in`.web.DocumentUseCase
import com.daegusw.apply.admission.web.adapter.api.request.DocumentRequest
import com.daegusw.apply.admission.web.adapter.api.response.DocumentResponse
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admission/document")
class DocumentController(
    private val documentUseCase: DocumentUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findDocument(
        @AuthenticatedPrincipalId id: MemberId
    ): DocumentResponse {
        return DocumentResponse(documentUseCase.find(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updateDocument(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestBody request: DocumentRequest
    ) {
        documentUseCase.update(id, request.toDocumentDto())
    }
}