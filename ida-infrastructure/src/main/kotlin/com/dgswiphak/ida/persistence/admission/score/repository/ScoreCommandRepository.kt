package com.dgswiphak.ida.persistence.admission.score.repository

import com.dgswiphak.ida.domain.admission.score.model.Score
import com.dgswiphak.ida.domain.admission.score.spi.query.CommandScoreSpi
import com.dgswiphak.ida.persistence.admission.score.mapper.ScoreMapper
import org.springframework.stereotype.Repository

@Repository
class ScoreCommandRepository(
    private val scoreRepository: ScoreRepository,
    private val scoreMapper: ScoreMapper
) : CommandScoreSpi{
    override fun save(score: Score) {
        scoreMapper.toDomain(scoreRepository.save(scoreMapper.toEntity(score)))
    }

}
