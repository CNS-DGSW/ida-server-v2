package com.dgswiphak.ida.domain.applicant.domain

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.domain.value.Privacy

data class Applicant(
    val id: MemberId,
    var privacy: Privacy
) {
    fun updatePrivacy(privacy: Privacy) {
        this.privacy = privacy
    }
}