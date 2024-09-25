package com.daegusw.apply.notice.application.port.`in`.web

import org.springframework.web.multipart.MultipartFile


interface NoticeAttachedUseCase{

    fun saveAttached(noticeId: Long, request: List<MultipartFile>)

    fun deleteAttached(noticeId: Long, fileName: String)
}