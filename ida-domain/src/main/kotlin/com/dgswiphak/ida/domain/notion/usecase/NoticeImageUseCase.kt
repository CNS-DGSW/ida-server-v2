package com.dgswiphak.ida.domain.notion.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.domain.notion.dto.response.ImageResponse
import org.springframework.core.io.Resource
import java.net.InetAddress
import java.nio.file.Paths


@UseCase
class NoticeImageUseCase(
    private val fileService: FileService
) {

    fun saveImage(fileRequest: FileRequest): ImageResponse {
        val imageName = fileService.save(FILE_DIR, fileRequest)
            .substringAfterLast("/")

        val imageUrl = "http://" + InetAddress.getLocalHost().hostAddress + ":8080/image/" + imageName

        return ImageResponse(imageUrl)
    }

    fun readImage(imageName: String): Resource {
        val filePath = Paths.get(FILE_DIR, imageName)

        return fileService.read(filePath.toUri().path)
    }

    fun deleteImage(imageName: String) {
        val filePath = Paths.get(FILE_DIR, imageName)

        fileService.delete(filePath.toUri().path)
    }

    companion object {
        const val FILE_DIR = "static/notice/image"
    }
}