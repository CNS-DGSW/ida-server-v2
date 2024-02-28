package com.dgswiphak.ida.domain.school.spi.query

import com.dgswiphak.ida.common.spi.QuerySpi
import com.dgswiphak.ida.domain.school.model.School

interface QuerySchoolSpi: QuerySpi<School, Long> {
    override fun findById(id: Long): School?
}