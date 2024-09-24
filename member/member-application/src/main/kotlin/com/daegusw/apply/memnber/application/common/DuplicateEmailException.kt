package com.daegusw.apply.memnber.application.common

class DuplicateEmailException(email: String) : RuntimeException(
    "$email is duplicated email"
)
