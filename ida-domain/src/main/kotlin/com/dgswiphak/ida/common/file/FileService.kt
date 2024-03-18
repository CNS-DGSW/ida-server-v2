package com.dgswiphak.ida.common.file

import com.dgswiphak.ida.common.dto.FileRequest

interface FileService {

    fun upload(fileRequest: FileRequest): String

    fun getResourceUrl(fileName: String): String

    fun delete(fileName: String)
}