package com.dgswiphak.ida.domain.admission.admission.exception

import com.dgswiphak.ida.common.error.IdaException

object NotFoundAdmissionException : IdaException(
    AdmissionErrorCode.NON_FOUND
)