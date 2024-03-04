package com.dgswiphak.ida.persistence.secondary.repository

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.persistence.secondary.entity.SecondaryEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SecondaryRepository: CrudRepository<SecondaryEntity, MemberId>