package com.daegusw.apply.admission.domain.admission.value

import java.time.LocalDateTime

data class Status(
     //제출 여부
     val submission: Boolean = false,

     //우편 도착
     val mailArrival: Boolean = false,

     //검토 여부
     val review: Boolean = false,

     // 제출 시각
     val submissionTime: LocalDateTime? = null,

     // 제출 확장 여부
     val confirmation: Boolean = false
)
