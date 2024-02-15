package com.dgswiphak.ida.common.util

import com.dgswiphak.ida.common.mapper.Mapper

object MapperUtils {
    fun <T, D> convertToDomainIsNull(convertTo: T?, domainMapper: Mapper<D, T>): D? {
        return convertTo?.let { domainMapper.toDomain(it) }
    }

    fun <T, D> convertToEntityIsNull(convertTo: D?, entityMapper: Mapper<D, T>): T? {
        return convertTo?.let { entityMapper.toEntity(it) }
    }

    fun <T> isNull(t: T?): Boolean {
        return t == null
    }
}
