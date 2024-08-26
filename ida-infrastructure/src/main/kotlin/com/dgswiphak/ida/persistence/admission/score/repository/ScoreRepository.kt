package com.dgswiphak.ida.persistence.admission.score.repository

import com.dgswiphak.ida.persistence.admission.score.entity.ScoreEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ScoreRepository : JpaRepository<ScoreEntity, Long> {
}
