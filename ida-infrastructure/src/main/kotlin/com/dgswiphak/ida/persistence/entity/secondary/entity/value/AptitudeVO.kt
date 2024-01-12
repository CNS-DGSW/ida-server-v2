package com.dgswiphak.ida.persistence.entity.secondary.entity.value

import jakarta.persistence.Embeddable
import java.io.Serial
import java.io.Serializable

@Embeddable
class AptitudeVO(
    
    var jopScore: Int

) : Serializable {

    companion object {
        @Serial
        private const val serialVersionUID: Long = 6438990741516639758L
    }

}