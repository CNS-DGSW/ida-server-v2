package com.dgswiphak.ida.persistence.school.repository

import com.dgswiphak.ida.domain.school.model.School
import com.dgswiphak.ida.domain.school.spi.query.CommandSchoolSpi
import com.dgswiphak.ida.persistence.school.mapper.SchoolMapper
import org.springframework.stereotype.Repository

@Repository
class CommandSchoolRepository(
    private val schoolRepository: SchoolRepository,
    private val schoolMapper: SchoolMapper
) : CommandSchoolSpi{
    override fun save(school: School) {
        schoolRepository.save(schoolMapper.toEntity(school))
    }

}