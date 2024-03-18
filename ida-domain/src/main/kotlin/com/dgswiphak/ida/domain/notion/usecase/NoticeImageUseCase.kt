package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.domain.notion.dto.response.ImageResponse

@UseCase
class NoticeImageUseCase(
    private val fileService: FileService
) {

    fun saveImage(fileRequest: FileRequest): ImageResponse {
        val imageName = fileService.upload(fileRequest)

        return ImageResponse(imageName)
    }

    fun deleteImage(imageName: String) {
        return fileService.delete(imageName)
    }
}