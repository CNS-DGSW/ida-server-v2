package com.dgswiphak.ida.aggregate.notice

import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.domain.notion.dto.request.CreateNoticeRequest
import com.dgswiphak.ida.domain.notion.dto.request.UpdateNoticeRequest
import com.dgswiphak.ida.domain.notion.dto.response.NoticeResponse
import com.dgswiphak.ida.domain.notion.dto.response.NoticesResponse
import com.dgswiphak.ida.domain.notion.usecase.*
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
@RequestMapping("/notice")
class NoticeWebAdapter(
    private val createNoticeUseCase: CreateNoticeUseCase,
    private val queryNoticeDetailsUseCase: QueryNoticeDetailsUseCase,
    private val queryNoticeAllUseCase: QueryNoticeAllUseCase,
    private val deleteNoticeUseCase: DeleteNoticeUseCase,
    private val updateNoticeUseCase: UpdateNoticeUseCase,
    private val attachedDownloadUseCase: AttachedDownloadUseCase
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNotice(
        @RequestPart("date") noticeRequest: CreateNoticeRequest,
        @RequestPart("file") multipartFile: List<MultipartFile>
    ) {
        val fileRequest = multipartFile.map {
            FileRequest(
                filename = it.originalFilename!!,
                contentType = it.contentType!!,
                fileData = it.bytes
            )
        }
        createNoticeUseCase.execute(noticeRequest, fileRequest)
    }

    @DeleteMapping("/{notice-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNotice(@PathVariable("notice-id") @NotNull noticeId: Long) {
        deleteNoticeUseCase.execute(noticeId)
    }

    @PatchMapping("/{notice-id}")
    fun updateNotice(
        @PathVariable("notice-id") @NotNull noticeId:Long,
        @RequestBody request: UpdateNoticeRequest
    ) {
        updateNoticeUseCase.execute(noticeId, request)
    }

    @GetMapping("/{notice-id}")
    fun queryDetailNotice(@PathVariable("notice-id") @NotNull noticeId: Long): NoticeResponse {
        return queryNoticeDetailsUseCase.execute(noticeId)
    }

    @GetMapping
    fun queryAllNotices(): NoticesResponse {
        return queryNoticeAllUseCase.execute()
    }

    @GetMapping("/file/{notice-id}/{fileName}")
    fun downloadAttached(
        @PathVariable("notice-id") @NotNull noticeId: Long,
        @PathVariable("fileName") @NotNull fileName: String
    ): ResponseEntity<Resource> {
        val resource = attachedDownloadUseCase.execute(noticeId, fileName)
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
}