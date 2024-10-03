package com.daegusw.apply.admission.web.adapter.api.response

import com.daegusw.apply.admission.domain.admission.constant.Progress

data class ProgressResponse(
    val progress: String
) {
    constructor(progress: Progress): this(
        progress = progress.value
    )
}