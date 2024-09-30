package com.daegusw.apply.core.file

import org.springframework.http.HttpHeaders
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.net.URLEncoder
import java.util.*
import javax.servlet.http.HttpServletResponse

fun MultipartFile.toFile(): File {
    val fileName = "${UUID.randomUUID()}_${this.originalFilename}"
    val file = File(fileName)

    FileOutputStream(file).use { outputStream ->
        outputStream.write(this.bytes)
    }

    return file
}

fun HttpServletResponse.setExcelContentDisposition(fileName: String) {
    setHeader(
        HttpHeaders.CONTENT_DISPOSITION,
        "attachment; filename=${URLEncoder.encode(fileName, "UTF-8")}.xlsx"
    )

    contentType = "ms-vnd/excel"
}