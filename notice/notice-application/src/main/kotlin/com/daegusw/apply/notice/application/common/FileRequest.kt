package com.daegusw.apply.notice.application.common

data class FileRequest(
    val filename: String,
    val contentType: String,
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