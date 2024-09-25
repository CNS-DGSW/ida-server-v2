package com.daegusw.apply.notice.application.port.`in`.web

import org.springframework.web.multipart.MultipartFile

interface NoticeImageUseCase{

    fun saveImage(fileRequest: MultipartFile): String

    fun deleteImage(imageName: String)
}