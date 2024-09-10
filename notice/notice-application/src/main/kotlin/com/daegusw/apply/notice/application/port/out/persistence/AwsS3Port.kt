package com.daegusw.apply.notice.application.port.out.persistence

import com.daegusw.apply.core.data.common.dto.FileRequest

interface AwsS3Port {

    fun upload(fileRequest: FileRequest): String

    fun getResourceUrl(fileName: String): String

    fun delete(fileName: String)
}