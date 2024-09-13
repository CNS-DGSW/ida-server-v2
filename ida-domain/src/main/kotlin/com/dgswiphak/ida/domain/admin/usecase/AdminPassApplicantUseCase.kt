package com.dgswiphak.ida.domain.admin.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.admin.dto.PassApplicantTableResponse
import com.dgswiphak.ida.domain.admission.admission.model.value.type.Progress
import com.dgswiphak.ida.domain.admission.admission.spi.QueryAdmissionSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi

@UseCase
class AdminPassApplicantUseCase(
    private val admissionSpi: QueryAdmissionSpi,
    private val applicantSpi: QueryApplicantSpi
) {

    fun getPassApplicantTable(): List<PassApplicantTableResponse> {
        val tableResponse: MutableList<PassApplicantTableResponse> = mutableListOf()
        val admission = admissionSpi.findAllByProgress(Progress.APPLY)
        var index = 1
        admission.forEach {
            val applicant = applicantSpi.findById(it.applicant!!.memberId)
            tableResponse.add(
                PassApplicantTableResponse(
                    index++, it, applicant
                )
            )

        }

        return tableResponse
    }
}