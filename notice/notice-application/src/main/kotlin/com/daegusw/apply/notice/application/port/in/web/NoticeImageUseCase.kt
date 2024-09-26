package com.daegusw.apply.notice.application.port.`in`.web

import java.io.File

interface NoticeImageUseCase{

    fun saveImage(file: File): String

    fun deleteImage(imageName: String)
}