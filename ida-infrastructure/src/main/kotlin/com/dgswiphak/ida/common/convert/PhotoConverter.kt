package com.dgswiphak.ida.common.convert

import com.dgswiphak.ida.domain.applicant.domain.value.Photo
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class PhotoConverter : AttributeConverter<Photo, String> {
    override fun convertToDatabaseColumn(photo: Photo?): String? {
        return photo?.filepath
    }

    override fun convertToEntityAttribute(vlaue: String?): Photo? {
        return vlaue?.let { Photo(it) }
    }
}