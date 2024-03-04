package com.dgswiphak.ida.domain.applicant.domain

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.domain.value.detail.Detail
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.Privacy

data class Applicant(
    val id: MemberId,
    var privacy: Privacy,
    var detail: Detail
) {
    fun updatePrivacy(privacy: Privacy) {
        this.privacy = privacy
    }

    fun updateDetail(detail: Detail) {
        this.detail = detail
    }
}