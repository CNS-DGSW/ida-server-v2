package com.dgswiphak.ida.domain.secondary.model

import com.dgswiphak.ida.domain.secondary.model.value.Aptitude
import com.dgswiphak.ida.domain.secondary.model.value.Interview

data class Secondary(

    val id: Long,

    val aptitude: Aptitude,

    val interview: Interview

)