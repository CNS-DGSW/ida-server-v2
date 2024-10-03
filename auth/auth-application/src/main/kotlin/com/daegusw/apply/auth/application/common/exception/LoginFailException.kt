package com.daegusw.apply.auth.application.common.exception

class LoginFailException : RuntimeException(
    "wrong email or password"
)