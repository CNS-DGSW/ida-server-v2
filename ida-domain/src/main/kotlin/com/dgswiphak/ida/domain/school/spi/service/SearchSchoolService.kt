package com.dgswiphak.ida.domain.school.spi.service

import com.dgswiphak.ida.domain.school.dto.response.SchoolResponse

interface SearchSchoolService {
    fun execute(state: String, q: String): List<SchoolResponse>
}