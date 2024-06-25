package com.dgswiphak.ida.common.util

import com.dgswiphak.ida.common.exception.FileTypeErrorException


object FileUtil {
    fun isValidPhotoExtension(extension: String) =
        when (extension.lowercase().substringAfter("/")) {
            "jpg", "jpeg", "png" -> true
            else -> false
        }
    fun validatePhotoExtension(contentType: String) {
        if (!isValidPhotoExtension(contentType)) {
            FileTypeErrorException
        }
    }
}