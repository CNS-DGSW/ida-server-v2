package com.daegusw.apply.notice.application.port.`in`.web

import com.daegusw.apply.core.data.common.dto.FileRequest

interface NoticeImageUseCase{

    fun saveImage(fileRequest: FileRequest): String

    fun deleteImage(imageName: String)
}