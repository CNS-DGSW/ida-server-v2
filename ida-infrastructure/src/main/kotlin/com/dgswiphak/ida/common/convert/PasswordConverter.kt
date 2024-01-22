package com.dgswiphak.ida.common.convert

import com.dgswiphak.ida.domain.member.model.value.Password
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter
class PasswordConverter : AttributeConverter<Password, String> {

    override fun convertToDatabaseColumn(password: Password?): String? {
        return password?.value
    }

    override fun convertToEntityAttribute(value: String?): Password? {
        return value?.let { Password(it) }
    }
}