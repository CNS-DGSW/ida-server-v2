package com.daegusw.apply.notice.application.port.out.aws.s3

import com.daegusw.apply.notice.application.common.FileRequest

interface AwsS3Port {

    fun upload(fileRequest: FileRequest): String

    fun getResourceUrl(fileName: String): String

    fun delete(fileName: String)
}