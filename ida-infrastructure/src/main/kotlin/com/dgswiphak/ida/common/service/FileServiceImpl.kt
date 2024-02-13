package com.dgswiphak.ida.common.service

import com.dgswiphak.ida.common.dto.FileRequest
import com.dgswiphak.ida.common.file.FileService
import com.dgswiphak.ida.common.util.IdGenerator
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.stereotype.Service
import java.io.File
import java.net.MalformedURLException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths


@Service
class FileServiceImpl: FileService {
    override fun save(path: String, fileRequest: FileRequest): String {
        val directory = File(path)

        if (!directory.exists()) {
            directory.mkdirs()
        }

        val filename = IdGenerator.generateUUIDWithString() + getFileExtension(fileRequest.contentType)

        val filePath = Paths.get(directory.absolutePath, filename)
        try {
            Files.write(filePath, fileRequest.fileData)
            return filePath.toString()
        } catch (e: Exception) {
            throw RuntimeException("Failed to save file", e)
        }
    }

    override fun download(path: String): Resource {
        val filePath: Path = Paths.get(path)
        try {
            val resource: Resource = UrlResource(filePath.toUri())
            if (!resource.exists() || !resource.isFile) {
                throw RuntimeException("file not found : $filePath")
            }
            return resource
        } catch (e: MalformedURLException) {
            throw RuntimeException()
        }
    }

    private fun getFileExtension(contentType: String): String {
        return "." + contentType.substringAfter('/')
    }
}