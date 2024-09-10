package com.daegusw.apply.notice.application.port.`in`.web

import com.daegusw.apply.core.data.common.dto.FileRequest


interface NoticeAttachedUseCase{

    fun saveAttached(noticeId: Long, request: List<FileRequest>)

    fun deleteAttached(noticeId: Long, fileName: String)
}