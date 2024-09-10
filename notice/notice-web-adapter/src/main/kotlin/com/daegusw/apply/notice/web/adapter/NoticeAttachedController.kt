package com.daegusw.apply.notice.web.adapter

import com.daegusw.apply.core.data.common.dto.FileRequest
import com.daegusw.apply.notice.application.port.`in`.web.NoticeAttachedUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import javax.validation.constraints.NotNull

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
        noticeAttachedUseCase.saveAttached(noticeId, fileRequest)
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{notice-id}/{file-name}")
    fun deleteAttached(
        @PathVariable("notice-id") @NotNull(message = "id is required") noticeId: Long,
        @PathVariable("file-name") @NotNull(message = "file name is required") fileName: String
    ) {
        noticeAttachedUseCase.deleteAttached(noticeId, fileName)
    }
}