package com.dgswiphak.ida.domain.notice.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService

@UseCase
class NoticeImageUseCase(
    private val fileService: FileService
) {

    fun saveImage(fileRequest: FileRequest): String {
        return fileService.upload(fileRequest)
    }

    fun deleteImage(imageName: String) {
        return fileService.delete(imageName)
    }
}