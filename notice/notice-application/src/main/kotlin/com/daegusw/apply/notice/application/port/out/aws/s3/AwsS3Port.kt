package com.daegusw.apply.notice.application.port.out.aws.s3

import org.springframework.web.multipart.MultipartFile

interface AwsS3Port {

    fun upload(fileRequest: MultipartFile): String

    fun getResourceUrl(fileName: String): String

    fun delete(fileName: String)
}