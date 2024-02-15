package com.dgswiphak.ida.common.convert

import com.dgswiphak.ida.common.model.PhoneNumber
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class PhoneNumberConvert : AttributeConverter<PhoneNumber, String> {
    override fun convertToDatabaseColumn(phoneNumber: PhoneNumber?): String? {
        return phoneNumber?.number
    }

    override fun convertToEntityAttribute(value: String?): PhoneNumber? {
        return value?.let { PhoneNumber(it) }
    }
}