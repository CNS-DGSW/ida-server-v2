package com.dgswiphak.ida.persistence.secondary.repository

import com.dgswiphak.ida.domain.secondary.model.Secondary
import com.dgswiphak.ida.domain.secondary.spi.query.CommandSecondarySpi
import com.dgswiphak.ida.persistence.secondary.mapper.SecondaryMapper
import org.springframework.stereotype.Repository

@Repository
class CommandSecondaryRepository(
    private val secondaryRepository: SecondaryRepository,
    private val secondaryMapper: SecondaryMapper
) : CommandSecondarySpi {

    override fun save(secondary: Secondary) {
        secondaryRepository.save(secondaryMapper.toEntity(secondary))
    }
}