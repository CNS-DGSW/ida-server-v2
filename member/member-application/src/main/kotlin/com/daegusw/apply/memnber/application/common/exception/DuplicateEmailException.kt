package com.daegusw.apply.memnber.application.common.exception

class DuplicateEmailException(email: String) : RuntimeException(
    "$email is duplicated email"
)
