package com.dgswiphak.ida.aggregate.notice

import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.domain.notion.dto.response.ImageResponse
import com.dgswiphak.ida.domain.notion.usecase.NoticeImageUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/image")
class NoticeImageController(
    private val noticeImageUseCase: NoticeImageUseCase
) {

    @PutMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    fun imageSave(@RequestPart("file") multipartFile: MultipartFile): ImageResponse {
        return noticeImageUseCase.saveImage(
            FileRequest(
                multipartFile.originalFilename!!,
                multipartFile.contentType!!,
                multipartFile.bytes
            )
        )
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{image-name}")
    fun imageDelete(@PathVariable("image-name") imageName: String) {
        noticeImageUseCase.deleteImage(imageName)
    }
}