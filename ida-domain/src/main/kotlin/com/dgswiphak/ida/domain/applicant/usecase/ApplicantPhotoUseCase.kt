package com.dgswiphak.ida.domain.applicant.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.util.FileUtil
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.Photo
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantPhotoResponse
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi

@UseCase
class ApplicantPhotoUseCase(
    private val fileService: FileService,
    private val queryApplicantSpi: QueryApplicantSpi,
    private val commandApplicantSpi: CommandApplicantSpi
) {
    fun updatePhoto(
        memberId: MemberId,
        file: FileRequest
    ) {
        if (!FileUtil.isValidPhotoExtension(file.contentType)) throw RuntimeException("Invalid photo extension: ${file.contentType}")
        val applicant = queryApplicantSpi.findById(memberId) ?: throw RuntimeException()
        fileService.save(PHOTO_DIR, file).also {
            applicant.privacy.updatePhoto(Photo.of(it))
        }
        commandApplicantSpi.save(applicant)
    }

    fun findPhoto(
        memberId: MemberId
    ): ApplicantPhotoResponse {
        val applicant = queryApplicantSpi.findById(memberId) ?: throw RuntimeException()
        val photo = applicant.privacy.photo
        return ApplicantPhotoResponse(if ((photo== null)) null else photo.filename)
    }


    companion object {
        const val PHOTO_DIR = "static/photo"
    }
}