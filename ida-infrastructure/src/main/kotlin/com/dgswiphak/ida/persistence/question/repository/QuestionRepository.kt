package com.dgswiphak.ida.persistence.question.repository

import com.dgswiphak.ida.persistence.question.entity.QuestionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface QuestionRepository: CrudRepository<QuestionEntity, Long>