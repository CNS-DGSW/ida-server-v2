package com.dgswiphak.ida.domain.applicant.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.util.FileUtil
import com.dgswiphak.ida.common.model.Photo
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi
import com.dgswiphak.ida.domain.applicant.usecase.exception.ApplicantTypeException
import com.dgswiphak.ida.domain.applicant.usecase.exception.ApplicationNotFoundException

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
        if (!FileUtil.isValidPhotoExtension(file.contentType)) throw ApplicantTypeException
        val applicant = queryApplicantSpi.findById(memberId) ?: throw ApplicationNotFoundException
        fileService.upload(file).also {
            applicant.privacy.updatePhoto(
                Photo(
                    value = it
                )
            )
        }
        commandApplicantSpi.save(applicant)
    }

    fun findPhoto(
        memberId: MemberId
    ): String? {
        val applicant = queryApplicantSpi.findById(memberId) ?: throw ApplicationNotFoundException
        val photo = applicant.privacy.photo
        return photo?.value
    }
}