package com.daegusw.apply.applicant.s3.adapter

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.internal.Mimetypes
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.DeleteObjectRequest
import com.daegusw.apply.applicant.application.port.out.aws.s3.StorageFilePort
import com.daegusw.apply.applicant.s3.adapter.common.AwsS3Properties
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException

@Component
class S3FileStorageAdapter(
    private val awsProperties: AwsS3Properties,
    private val amazonS3Client: AmazonS3Client
) : StorageFilePort {
    override fun upload(file: File): String {
        uploadS3(file)

        return getResourceUrl(file.name)
    }

    override fun find(fileName: String): String {
        return getResourceUrl(fileName)
    }

    private fun uploadS3(file: File) {
        try {
            val inputStream = file.inputStream()
            val objectMetadata = ObjectMetadata().apply {
                this.contentType = Mimetypes.getInstance().getMimetype(file.extension)
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

    fun getResourceUrl(fileName: String): String {
        return amazonS3Client.getResourceUrl(awsProperties.bucket, fileName)
    }

    fun delete(fileName: String) {
        amazonS3Client.deleteObject(DeleteObjectRequest(awsProperties.bucket, fileName))
    }
}