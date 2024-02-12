package com.dgswiphak.ida.common.util

object FileUtil {
    fun isValidPhotoExtension(extension: String) =
        when (extension.lowercase().substringAfter("/")) {
            "jpg", "jpeg", "png" -> true
            else -> false
        }
}