package com.daegusw.apply.admission.web.adapter.api.request

import com.daegusw.apply.admission.domain.admission.constant.ApplyType

data class ApplyTypeRequest(
    val type: ApplyType
)