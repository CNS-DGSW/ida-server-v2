package com.dgswiphak.ida.aggregate.notice

import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.domain.notion.usecase.NoticeAttachedUseCase
import org.jetbrains.annotations.NotNull
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.UnsupportedEncodingException
import java.lang.RuntimeException
import java.net.URLEncoder

@RestController
@RequestMapping("/attached")
class NoticeAttachedController(
    private val noticeAttachedUseCase: NoticeAttachedUseCase
) {

    @PutMapping("/{notice-id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveAttached(
        @PathVariable("notice-id") @NotNull noticeId: Long,
        @RequestPart multipartFile: List<MultipartFile>
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

    @GetMapping("/{notice-id}/{fileName}")
    fun downloadAttached(
        @PathVariable("notice-id") @NotNull noticeId: Long,
        @PathVariable("fileName") @NotNull fileName: String
    ): ResponseEntity<Resource> {
        val resource = noticeAttachedUseCase.download(noticeId, fileName)
        try {
            val originalName = URLEncoder.encode(fileName, "UTF-8")
            return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=$originalName")
                .body(resource)

        } catch (e: UnsupportedEncodingException) {
            throw RuntimeException()
        }
    }

    @DeleteMapping("/{notice-id}/{fileName}")
    fun deleteAttached(
        @PathVariable("notice-id") @NotNull noticeId: Long,
        @PathVariable("fileName") @NotNull fileName: String
    ) {
        noticeAttachedUseCase.delete(noticeId, fileName)
    }
}