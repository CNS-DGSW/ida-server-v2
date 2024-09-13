package com.dgswiphak.ida.domain.admin.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.domain.admin.dto.SecondaryTableResponse
import com.dgswiphak.ida.domain.admin.dto.excel.AptitudeExcel
import com.dgswiphak.ida.domain.admin.dto.excel.InterviewExcel
import com.dgswiphak.ida.domain.admission.admission.model.value.type.Progress
import com.dgswiphak.ida.domain.admission.admission.spi.QueryAdmissionSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi
import com.dgswiphak.ida.domain.secondary.spi.query.QuerySecondarySpi

@UseCase
class AdminSecondaryUseCase(
    private val admissionSpi: QueryAdmissionSpi,
    private val applicantSpi: QueryApplicantSpi,
    private val secondarySpi: QuerySecondarySpi,
) {

    fun getSecondaryTable(): List<SecondaryTableResponse> {
        val tableResponse: MutableList<SecondaryTableResponse> = mutableListOf()
        val admission = admissionSpi.findAllByProgress(Progress.FIRST)
        var index = 1
        admission.forEach {
            val applicant = applicantSpi.findById(it.applicant!!.memberId)
            val secondary = secondarySpi.findById(it.applicant!!.memberId)
            tableResponse.add(
                SecondaryTableResponse(
                    index++, applicant, it, secondary
                )
            )
        }

        return tableResponse
    }

    fun jobExcelDownload(): List<AptitudeExcel> {
        val response: MutableList<AptitudeExcel> = mutableListOf()
        val admission = admissionSpi.findAllByProgress(Progress.FIRST)
        var index = 1
        admission.forEach {
            val applicant = applicantSpi.findById(it.applicant!!.memberId)
            val secondary = secondarySpi.findById(it.applicant!!.memberId)
            response.add(
                AptitudeExcel(index++, applicant, secondary)
            )
        }

        return response
    }

    fun interviewExcelDownload(): List<InterviewExcel> {
        val response: MutableList<InterviewExcel> = mutableListOf()
        val admission = admissionSpi.findAllByProgress(Progress.FIRST)
        var index = 1
        admission.forEach {
            val applicant = applicantSpi.findById(it.applicant!!.memberId)
            val secondary = secondarySpi.findById(it.applicant!!.memberId)
            response.add(
                InterviewExcel(index++, applicant, secondary)
            )
        }

        return response
    }
}