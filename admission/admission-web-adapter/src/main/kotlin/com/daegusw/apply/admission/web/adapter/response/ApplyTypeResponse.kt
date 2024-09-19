package com.daegusw.apply.admission.web.adapter.response

import com.daegusw.apply.admission.domain.admission.constant.ApplyType
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class ApplyTypeResponse(
    val type: ApplyType,
    val category: ApplyType.Category?,
    val subCategory: ApplyType.SubCategory?
) {
    constructor(applyType: ApplyType): this(
        type = applyType,
        category = applyType.mainCategory,
        subCategory = applyType.subCategory
    )
}