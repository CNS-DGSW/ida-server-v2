package com.daegusw.apply.notice.application.port.out.aws.s3

import java.io.File

interface AwsS3Port {

    fun upload(file: File): String

    fun getResourceUrl(fileName: String): String

    fun delete(fileName: String)
}