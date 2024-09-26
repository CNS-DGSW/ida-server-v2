package com.daegusw.apply.admin.domain.admin.service

import com.daegusw.apply.admin.domain.admin.dto.ApplicantTableResponse
import com.daegusw.apply.admission.application.port.out.persistence.QueryAdmissionPort
import com.daegusw.apply.applicant.application.port.out.persistence.QueryApplicantPort
import org.springframework.stereotype.Service

@Service
class AdminApplicantService(
    private val queryApplicantPort: QueryApplicantPort,
    private val queryAdmissionPort: QueryAdmissionPort
) {

    fun getApplicantTable(): List<ApplicantTableResponse> {
        val tableResponse: MutableList<ApplicantTableResponse> = mutableListOf()
        val admission = queryAdmissionPort.findAll()
        var index = 1
        admission.forEach {
            val applicant = queryApplicantPort.findById(it.applicant!!.member)
            tableResponse.add(
                ApplicantTableResponse(
                    index++, applicant, it
                )
            )

        }

        return tableResponse
    }
}