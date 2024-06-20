package com.dgswiphak.ida.common.annotation

import jakarta.validation.Constraint
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [PasswordValidator::class])
annotation class ValidPassword(
    val message: String = "Invalid password",
    val groups: Array<KClass<*>> = [],
    val payload: Array<KClass<out Payload>> = []
)

class PasswordValidator : ConstraintValidator<ValidPassword, String> {
    override fun isValid(password: String?, context: ConstraintValidatorContext): Boolean {
        if (password == null) return false
        val hasUpperCase = password.any { it.isUpperCase() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val hasSpecialChar = password.any { "!@#$%^&*|\"':₩\\?`~".contains(it) }

        val conditionsMet = listOf(hasUpperCase, hasLowerCase, hasDigit, hasSpecialChar).count { it }
        return password.length >= 9 && conditionsMet >= 3
    }
}