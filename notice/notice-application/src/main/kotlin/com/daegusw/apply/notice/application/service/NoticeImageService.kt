package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.port.`in`.web.NoticeImageUseCase
import com.daegusw.apply.notice.application.port.out.aws.s3.AwsS3Port
import org.springframework.stereotype.Service
import java.io.File

@Service
class NoticeImageService(
    private val awsS3Port: AwsS3Port
) : NoticeImageUseCase {

    override fun saveImage(file: File): String {
        return awsS3Port.upload(file)
    }

    override fun deleteImage(imageName: String) {
        return awsS3Port.delete(imageName)
    }
}