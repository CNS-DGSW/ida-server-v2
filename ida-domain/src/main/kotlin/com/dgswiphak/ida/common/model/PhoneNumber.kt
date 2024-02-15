package com.dgswiphak.ida.common.model

data class PhoneNumber(
    val number: String
) {
    companion object {
        fun of(number: String) : PhoneNumber {
            return PhoneNumber(number)
        }
    }
}