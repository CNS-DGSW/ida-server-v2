package com.dgswiphak.ida.domain.applicant.usecase.exception

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.domain.applicant.usecase.exception.error.ApplicantErrorCode

object ApplicantTypeException : IdaException(
    ApplicantErrorCode.TYPE_ERROR
)