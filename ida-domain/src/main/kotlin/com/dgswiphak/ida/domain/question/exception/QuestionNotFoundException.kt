package com.dgswiphak.ida.domain.question.exception

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.domain.question.exception.error.QuestionErrorCode

object QuestionNotFoundException: IdaException(
    QuestionErrorCode.NOT_FOUND
)