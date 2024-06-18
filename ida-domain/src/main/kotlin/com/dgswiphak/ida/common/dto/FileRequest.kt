package com.dgswiphak.ida.common.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class FileRequest(
    @field:NotBlank(message = "Name is required")
    val filename: String,
    @field:NotBlank(message = "Content Type is required")
    val contentType: String,
    @field:NotNull(message = "File Data is required")
    val fileData: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FileRequest

        if (filename != other.filename) return false
        if (!fileData.contentEquals(other.fileData)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = filename.hashCode()
        result = 31 * result + fileData.contentHashCode()
        return result
    }
}