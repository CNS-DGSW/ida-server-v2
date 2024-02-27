package com.dgswiphak.ida.persistence.school.repository

import com.dgswiphak.ida.persistence.school.entity.SchoolEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SchoolRepository : CrudRepository<SchoolEntity, Long> {
}