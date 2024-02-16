package com.dgswiphak.ida.aggregate.notice

import com.dgswiphak.ida.domain.notion.dto.request.CreateNoticeRequest
import com.dgswiphak.ida.domain.notion.dto.request.UpdateNoticeRequest
import com.dgswiphak.ida.domain.notion.dto.response.NoticeResponse
import com.dgswiphak.ida.domain.notion.dto.response.NoticesResponse
import com.dgswiphak.ida.domain.notion.model.Notice
import com.dgswiphak.ida.domain.notion.usecase.*
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/notice")
class NoticeController(
    private val createNoticeUseCase: CreateNoticeUseCase,
    private val queryNoticeDetailsUseCase: QueryNoticeDetailsUseCase,
    private val queryNoticeAllUseCase: QueryNoticeAllUseCase,
    private val deleteNoticeUseCase: DeleteNoticeUseCase,
    private val updateNoticeUseCase: UpdateNoticeUseCase,
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNotice(@RequestBody noticeRequest: CreateNoticeRequest): Notice {
        return createNoticeUseCase.execute(noticeRequest)
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
}