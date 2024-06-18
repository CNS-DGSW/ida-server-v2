package com.dgswiphak.ida.aggregate.notice

import com.dgswiphak.ida.common.dto.FileRequest import com.dgswiphak.ida.domain.notice.usecase.NoticeAttachedUseCase
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/attached")
class NoticeAttachedController(
    private val noticeAttachedUseCase: NoticeAttachedUseCase
) {

    @PutMapping("/{notice-id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveAttached(
        @PathVariable("notice-id") @NotNull(message = "id is required") noticeId: Long,
        @NotNull(message = "file is required") @RequestPart(value = "files") multipartFile: List<MultipartFile>
    ) {
        val fileRequest = multipartFile.map {
            FileRequest(
                filename = it.originalFilename!!,
                contentType = it.contentType!!,
                fileData = it.bytes
            )
        }
        noticeAttachedUseCase.save(noticeId, fileRequest)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{notice-id}/{file-name}")
    fun deleteAttached(
        @PathVariable("notice-id") @NotNull(message = "id is required") noticeId: Long,
        @PathVariable("file-name") @NotNull(message = "file name is required") fileName: String
    ) {
        noticeAttachedUseCase.delete(noticeId, fileName)
    }
}