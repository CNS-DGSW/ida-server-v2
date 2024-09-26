package com.daegusw.apply.notice.s3.adapter

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.internal.Mimetypes
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.daegusw.apply.notice.application.port.out.aws.s3.AwsS3Port
import com.daegusw.apply.notice.s3.adapter.common.properties.NoticeAwsS3Properties
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.io.File
import java.io.IOException

@Service
class NoticeAwsS3Adapter(
    private val awsProperties: NoticeAwsS3Properties,
    @Qualifier("noticeS3Client")
    private val amazonS3Client: AmazonS3Client
) : AwsS3Port {

    override fun upload(file: File): String {
        uploadS3(file)

        return getResourceUrl(file.name)
    }

    private fun uploadS3(file: File) {
        try {
            val inputStream = file.inputStream()
            val objectMetadata = ObjectMetadata().apply {
                this.contentType = Mimetypes.getInstance().getMimetype(file.canonicalFile)
                this.contentLength = file.length()
            }

            amazonS3Client.putObject(
                PutObjectRequest(awsProperties.bucket, file.name, inputStream, objectMetadata)
                    .withCannedAcl(
                        CannedAccessControlList.PublicRead
                    )
            )
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    override fun getResourceUrl(fileName: String): String {
        return amazonS3Client.getResourceUrl(awsProperties.bucket, fileName)
    }

    override fun delete(fileName: String) {
        amazonS3Client.deleteObject(DeleteObjectRequest(awsProperties.bucket, fileName))
    }
}