package com.daegusw.apply.notice.web.adapter

import com.daegusw.apply.notice.application.common.FileRequest
import com.daegusw.apply.notice.application.port.`in`.web.NoticeImageUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/image")
class NoticeImageController(
    private val noticeImageUseCase: NoticeImageUseCase
) {

    @PutMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    fun imageSave(@NotNull(message = "file is required") @RequestPart("file") multipartFile: MultipartFile): String {
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