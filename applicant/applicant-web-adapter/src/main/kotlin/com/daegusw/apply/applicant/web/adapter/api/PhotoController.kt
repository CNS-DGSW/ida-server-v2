package com.daegusw.apply.applicant.web.adapter.api

import com.daegusw.apply.applicant.application.port.`in`.web.PhotoUseCase
import com.daegusw.apply.applicant.web.adapter.api.response.PhotoResponse
import com.daegusw.apply.core.authentication.AuthenticatedPrincipalId
import com.daegusw.apply.member.id.MemberId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import com.daegusw.apply.core.file.toFile

@RestController
@RequestMapping("/applicant/photo")
class PhotoController(
    private val photoUseCase: PhotoUseCase
) {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findPhoto(
        @AuthenticatedPrincipalId id: MemberId
    ): PhotoResponse {
        return PhotoResponse(photoUseCase.find(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updatePhoto(
        @AuthenticatedPrincipalId id: MemberId,
        @RequestPart file: MultipartFile
    ) {
        photoUseCase.update(id, file.toFile())
    }
}