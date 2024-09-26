package com.daegusw.apply.notice.application.port.`in`.web

import java.io.File


interface NoticeAttachedUseCase{

    fun saveAttached(noticeId: Long, files: List<File>)

    fun deleteAttached(noticeId: Long, fileName: String)
}