package com.daegusw.apply.memnber.application.exception

class DuplicateEmailException(email: String) : RuntimeException(
    "$email is duplicated email"
)
