package com.daegusw.apply.admin.service

import com.daegusw.apply.admin.dto.SecondaryTableResponse
import com.daegusw.apply.admin.dto.excel.AptitudeExcel
import com.daegusw.apply.admin.dto.excel.InterviewExcel
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import com.daegusw.apply.secondary.application.QuerySecondaryPort
import org.springframework.stereotype.Service

@Service
class AdminSecondaryGradeService(
    private val queryApplicantPort: QueryApplicantPort,
    private val queryAdmissionPort: QueryAdmissionPort,
    private val querySecondaryPort: QuerySecondaryPort
) {

    fun getSecondaryTable(): List<SecondaryTableResponse> {
        val tableResponse: MutableList<SecondaryTableResponse> = mutableListOf()
        val admission = queryAdmissionPort.findAllByProgress(Progress.FIRST_PASSED)
        var index = 1
        admission.forEach {
            val applicant = queryApplicantPort.findById(it.applicant?.member!!)
            val secondary = querySecondaryPort.findByAdmission(it)

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
        val admission = queryAdmissionPort.findAllByProgress(Progress.FIRST_PASSED)
        var index = 1
        admission.forEach {
            val applicant = queryApplicantPort.findById(it.applicant?.member!!)
            val secondary = querySecondaryPort.findByAdmission(it)
            response.add(
                AptitudeExcel(index++, applicant, secondary)
            )
        }

        return response
    }

    fun interviewExcelDownload(): List<InterviewExcel> {
        val response: MutableList<InterviewExcel> = mutableListOf()
        val admission = queryAdmissionPort.findAllByProgress(Progress.FIRST_PASSED)
        var index = 1
        admission.forEach {
            val applicant = queryApplicantPort.findById(it.applicant?.member!!)
            val secondary = querySecondaryPort.findByAdmission(it)
            response.add(
                InterviewExcel(index++, applicant, secondary)
            )
        }

        return response
    }
}