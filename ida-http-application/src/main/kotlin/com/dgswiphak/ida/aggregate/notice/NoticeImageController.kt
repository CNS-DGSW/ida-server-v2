package com.dgswiphak.ida.aggregate.notice

import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.domain.notion.dto.response.ImageResponse
import com.dgswiphak.ida.domain.notion.usecase.NoticeImageUseCase
import org.springframework.core.io.Resource
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import kotlin.io.path.Path

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

    @GetMapping("/{image-name}")
    fun imageRead(@PathVariable("image-name") imageName: String): ResponseEntity<Resource> {
        val image = noticeImageUseCase.readImage(imageName)

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(Files.probeContentType(Path(image.url.path))))
            .body(noticeImageUseCase.readImage(imageName))
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{image-name}")
    fun imageDelete(@PathVariable("image-name") imageName: String) {
        noticeImageUseCase.deleteImage(imageName)
    }
}