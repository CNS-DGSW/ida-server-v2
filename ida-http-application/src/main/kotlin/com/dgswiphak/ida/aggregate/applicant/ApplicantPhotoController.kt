package com.dgswiphak.ida.aggregate.applicant

import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantPhotoResponse
import com.dgswiphak.ida.domain.applicant.usecase.ApplicantPhotoUseCase
import com.dgswiphak.ida.global.auth.annotation.AuthenticatedPrincipalId
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/applicant/photo")
class ApplicantPhotoController(
    private val applicantPhotoUseCase: ApplicantPhotoUseCase
) {
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun updatePhoto(
        @AuthenticatedPrincipalId memberId: MemberId,
        @RequestParam(value = "photo", required = true) photo: MultipartFile
    ) {
        return applicantPhotoUseCase.updatePhoto(
            memberId,
            FileRequest(photo.originalFilename!!, photo.contentType!!, photo.bytes)
        )
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findPhoto(
        @AuthenticatedPrincipalId memberId: MemberId,
    ): ApplicantPhotoResponse {
        return applicantPhotoUseCase.findPhoto(memberId)
    }
}