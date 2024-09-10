package com.daegusw.apply.notice.web.adapter

import com.daegusw.apply.notice.application.port.`in`.web.*
import com.daegusw.apply.notice.web.adapter.request.CreateNoticeRequest
import com.daegusw.apply.notice.web.adapter.request.UpdateNoticeRequest
import com.daegusw.apply.notice.web.adapter.response.NoticeResponse
import com.daegusw.apply.notice.web.adapter.response.NoticesResponse
import com.dgswiphak.ida.domain.notice.model.Notice
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
        return createNoticeUseCase.createNotice(noticeRequest.toCommand())
    }

    @DeleteMapping("/{notice-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteNotice(@PathVariable("notice-id") @NotNull noticeId: Long) {
        deleteNoticeUseCase.deleteNotice(noticeId)
    }

    @PatchMapping("/{notice-id}")
    fun updateNotice(
        @PathVariable("notice-id") @NotNull noticeId:Long,
        @RequestBody request: UpdateNoticeRequest
    ) {
        updateNoticeUseCase.updateNotice(noticeId, request.toCommand())
    }

    @GetMapping("/{notice-id}")
    fun queryDetailNotice(@PathVariable("notice-id") @NotNull noticeId: Long): NoticeResponse {
        return NoticeResponse.detailOf(queryNoticeDetailsUseCase.queryNoticeDerails(noticeId))
    }

    @GetMapping
    fun queryAllNotices(): NoticesResponse {
        val notices = queryNoticeAllUseCase.queryNoticeAll()
        return NoticesResponse(
            notices.map {
                NoticeResponse.of(it)
            }
        )
    }
}