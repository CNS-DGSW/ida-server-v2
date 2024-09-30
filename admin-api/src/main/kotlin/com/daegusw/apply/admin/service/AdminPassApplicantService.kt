package com.daegusw.apply.admin.service

import com.daegusw.apply.admin.dto.PassApplicantTableResponse
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.admission.domain.admission.constant.Progress
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import org.springframework.stereotype.Service

@Service
class AdminPassApplicantService(
    private val queryApplicantPort: QueryApplicantPort,
    private val queryAdmissionPort: QueryAdmissionPort
) {

    fun getPassApplicantTable(): List<PassApplicantTableResponse> {
        val tableResponse: MutableList<PassApplicantTableResponse> = mutableListOf()
        val admission = queryAdmissionPort.findAllByProgress(Progress.PASSED)
        var index = 1
        admission.forEach {
            val applicant = queryApplicantPort.findById(it.applicant!!.member)
            tableResponse.add(
                PassApplicantTableResponse(
                    index++, it, applicant
                )
            )

        }

        return tableResponse
    }
}