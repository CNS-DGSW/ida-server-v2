package com.dgswiphak.ida.domain.secondary.model

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.secondary.model.value.Aptitude
import com.dgswiphak.ida.domain.secondary.model.value.Interview

data class Secondary(

    val id: MemberId,

    val aptitude: Aptitude,

    val interview: Interview

)