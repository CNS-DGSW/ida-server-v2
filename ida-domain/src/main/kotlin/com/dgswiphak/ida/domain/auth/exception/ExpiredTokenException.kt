package com.dgswiphak.ida.domain.auth.exception

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.domain.auth.exception.error.TokenErrorCode

object ExpiredTokenException : IdaException(
    TokenErrorCode.EXPIRED_TOKEN
)