package com.daegusw.apply.s3.adapter

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.internal.Mimetypes
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.daegusw.apply.core.data.common.dto.FileRequest
import com.daegusw.apply.notice.application.port.out.persistence.AwsS3Port
import com.daegusw.apply.s3.adapter.common.properties.AwsS3Properties
import org.springframework.stereotype.Service
import java.io.IOException

@Service
class AwsS3Adapter(
    private val awsProperties: AwsS3Properties,
    private val amazonS3Client: AmazonS3Client
) : AwsS3Port {

    override fun upload(fileRequest: FileRequest): String {
        uploadS3(fileRequest)

        return getResourceUrl(fileRequest.filename)
    }

    private fun uploadS3(fileRequest: FileRequest) {
        try {
            val inputStream = fileRequest.fileData.inputStream()
            val objectMetadata = ObjectMetadata().apply {
                this.contentType = Mimetypes.getInstance().getMimetype(fileRequest.contentType)
            }

            amazonS3Client.putObject(
                PutObjectRequest(awsProperties.bucket, fileRequest.filename, inputStream, objectMetadata)
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