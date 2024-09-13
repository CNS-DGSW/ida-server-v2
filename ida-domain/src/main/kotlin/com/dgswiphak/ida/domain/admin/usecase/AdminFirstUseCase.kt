package com.dgswiphak.ida.domain.admin.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.admin.dto.FirstTableResponse
import com.dgswiphak.ida.domain.admission.admission.spi.QueryAdmissionSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi

@UseCase
class AdminFirstUseCase(
    private val admissionSpi: QueryAdmissionSpi,
    private val applicantSpi: QueryApplicantSpi
) {

    fun getFirstTable(): List<FirstTableResponse> {
        val tableResponse: MutableList<FirstTableResponse> = mutableListOf()
        val admission = admissionSpi.findAll()
        var index = 1
        admission.forEach {
            val applicant = applicantSpi.findById(it.applicant!!.memberId)
            tableResponse.add(
                FirstTableResponse(
                    index++, applicant, it
                )
            )

        }

        return tableResponse
    }
}