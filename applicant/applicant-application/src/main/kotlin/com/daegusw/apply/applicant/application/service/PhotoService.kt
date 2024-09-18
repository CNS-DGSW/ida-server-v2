package com.daegusw.apply.applicant.application.service

import com.daegusw.apply.applicant.application.common.exception.ApplicantDoesNotExistException
import com.daegusw.apply.applicant.application.port.`in`.web.PhotoUseCase
import com.daegusw.apply.applicant.application.port.out.aws.s3.StorageFilePort
import com.daegusw.apply.applicant.application.port.out.persistence.CommandApplicantPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.member.id.MemberId
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.File

@Service
class PhotoService(
    private val queryApplicantPort: QueryApplicantPort,
    private val commandApplicantPort: CommandApplicantPort,
    private val storageFilePort: StorageFilePort
) : PhotoUseCase {
    @Transactional(readOnly = true)
    override fun find(memberId: MemberId): String? {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        if (applicant.privacy?.photo == null) return null

        return storageFilePort.find(applicant.privacy?.photo!!)
    }

    @Transactional(rollbackFor = [Exception::class])
    override fun update(memberId: MemberId, file: File) {
        val applicant = queryApplicantPort.findById(memberId) ?: throw ApplicantDoesNotExistException(memberId)

        applicant.privacy?.updatePhoto(storageFilePort.upload(file))

        commandApplicantPort.save(applicant)
    }
}