package com.dgswiphak.ida.domain.school.spi.query

import com.dgswiphak.ida.domain.school.model.School

interface CommandSchoolSpi {
    fun save(school: School)
}