package com.dgswiphak.ida.domain.auth.exception

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.domain.auth.exception.error.TokenErrorCode

object InvalidTokenException : IdaException(
    TokenErrorCode.INVALID_TOKEN
)