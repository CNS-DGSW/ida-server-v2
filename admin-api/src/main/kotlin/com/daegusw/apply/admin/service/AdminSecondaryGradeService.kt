package com.daegusw.apply.admin.service

import com.daegusw.apply.admin.dto.SecondaryTableResponse
import com.daegusw.apply.admin.dto.excel.AptitudeExcel
import com.daegusw.apply.admin.dto.excel.InterviewExcel
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import org.springframework.stereotype.Service

@Service
class AdminSecondaryGradeService(
    private val queryApplicantPort: QueryApplicantPort,
    private val queryAdmissionPort: QueryAdmissionPort,
//    private val secondarySpi: SecondaryRepository
) {

    fun getSecondaryTable(): List<SecondaryTableResponse> {
        val tableResponse: MutableList<SecondaryTableResponse> = mutableListOf()
        val admission = queryAdmissionPort.findAllByProgress(Progress.FIRST_PASSED)
        var index = 1
        admission.forEach {
            val applicant = queryApplicantPort.findById(it.applicant?.member!!)
            //TODO Secondary Repository
//           val secondary = secondarySpi.findById(it.applicant?.member!!)

            tableResponse.add(
                SecondaryTableResponse(
                    index++, applicant, it, TODO()
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
/*            val secondary = secondarySpi.findByMemberId(it.applicant?.member!!)*/
            response.add(
                AptitudeExcel(index++, applicant, TODO("secondary"))
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
            /*val secondary = secondarySpi.findByMemberId(it.applicant?.member!!)*/
            response.add(
                InterviewExcel(index++, applicant, TODO("secondary"))
            )
        }

        return response
    }
}