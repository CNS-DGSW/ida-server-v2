package com.dgswiphak.ida.common.util

import com.dgswiphak.ida.domain.applicant.usecase.exception.error.ApplicantErrorCode

object FileUtil {
    fun isValidPhotoExtension(extension: String) =
        when (extension.lowercase().substringAfter("/")) {
            "jpg", "jpeg", "png" -> true
            else -> false
        }
    fun validatePhotoExtension(contentType: String) {
        if (!isValidPhotoExtension(contentType)) {
            ApplicantErrorCode.TYPE_ERROR
        }
    }
}