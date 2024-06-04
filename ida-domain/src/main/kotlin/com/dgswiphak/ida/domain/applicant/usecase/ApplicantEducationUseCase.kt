package com.dgswiphak.ida.domain.applicant.usecase

import com.dgswiphak.ida.common.annotation.UseCase
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.domain.applicant.model.value.education.Education
import com.dgswiphak.ida.domain.applicant.dto.request.UpdateApplicantEducationRequest
import com.dgswiphak.ida.domain.applicant.dto.response.ApplicantEducationResponse
import com.dgswiphak.ida.domain.applicant.spi.query.CommandApplicantSpi
import com.dgswiphak.ida.domain.applicant.spi.query.QueryApplicantSpi

@UseCase
class ApplicantEducationUseCase(
    private val queryApplicantSpi: QueryApplicantSpi,
    private val commandApplicantSpi: CommandApplicantSpi
) {
    fun updateEducation(id: MemberId, request: UpdateApplicantEducationRequest) {
        val applicant = queryApplicantSpi.findById(id) ?: throw RuntimeException()

        applicant.updateEducation(updateSchoolInfo(applicant.education, request))

        commandApplicantSpi.save(applicant)
    }

    fun findEducation(id: MemberId): ApplicantEducationResponse{
        val applicant = queryApplicantSpi.findById(id) ?: throw RuntimeException()

        return ApplicantEducationResponse(applicant.education.graduationType, applicant.education.graduateYear, applicant.education.school, applicant.education.teacher)
    }

    private fun updateSchoolInfo(education: Education, request: UpdateApplicantEducationRequest): Education {
        education.graduationType = request.graduationType
        education.graduateYear = request.graduateYear
        education.updateSchool(request.toSchool())
        education.updateTeacher(request.toTeacher())

        return education
    }
}