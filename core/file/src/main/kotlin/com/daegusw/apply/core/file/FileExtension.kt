package com.daegusw.apply.core.file

import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.util.*

fun MultipartFile.toFile(): File {
    val fileName = "${UUID.randomUUID()}_${this.originalFilename}"
    val file = File(fileName)

    FileOutputStream(file).use { outputStream ->
        outputStream.write(this.bytes)
    }

    return file
}