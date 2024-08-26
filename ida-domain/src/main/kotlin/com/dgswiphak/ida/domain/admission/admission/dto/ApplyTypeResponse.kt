package com.dgswiphak.ida.domain.admission.admission.dto

import com.dgswiphak.ida.domain.admission.admission.model.value.type.ApplyType
import com.fasterxml.jackson.annotation.JsonInclude

data class ApplyTypeResponse(
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val mainCategory: ApplyType.Category?,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val subCategory: ApplyType.SubCategory?,
    val type: ApplyType
)
