package com.daegusw.apply.applicant.application.port.out.aws.s3

import java.io.File

interface StorageFilePort {
    fun upload(file: File): String

    fun find(fileName: String): String
}