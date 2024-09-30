package com.daegusw.apply.admin.service

import com.daegusw.apply.admin.dto.FirstTableResponse
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import org.springframework.stereotype.Service

@Service
class AdminFirstGradeService(
        private val queryApplicantPort: QueryApplicantPort,
        private val queryAdmissionPort: QueryAdmissionPort
) {

    fun getFirstTable(): List<FirstTableResponse> {
        val tableResponse: MutableList<FirstTableResponse> = mutableListOf()
        val admission = queryAdmissionPort.findAll()
        var index = 1
        admission.forEach {
            val applicant = queryApplicantPort.findById(it.applicant!!.member)
            tableResponse.add(
                FirstTableResponse(
                    index++, applicant, it
                )
            )

        }

        return tableResponse
    }
}