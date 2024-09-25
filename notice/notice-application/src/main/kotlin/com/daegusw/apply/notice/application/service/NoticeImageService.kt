package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.port.`in`.web.NoticeImageUseCase
import com.daegusw.apply.notice.application.port.out.aws.s3.AwsS3Port
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class NoticeImageService(
    private val awsS3Port: AwsS3Port
) : NoticeImageUseCase {

    override fun saveImage(fileRequest: MultipartFile): String {
        return awsS3Port.upload(fileRequest)
    }

    override fun deleteImage(imageName: String) {
        return awsS3Port.delete(imageName)
    }
}