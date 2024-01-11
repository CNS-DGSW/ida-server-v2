package com.dgswiphak.ida.persistence.common.mapper

interface GenericMapper<D, E> {

    fun toDomain(entity: E?): D?

    fun toEntity(domain: D): E
}