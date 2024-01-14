package com.dgswiphak.ida.persistence.secondary.entity.value

import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable

@Embeddable
class InterviewVO(

    val studyCompetence: Int,

    val computingCompetence: Int

) : Serializable {

    companion object {
        @Serial
        private const val serialVersionUID: Long = -437300054465939296L
    }

}