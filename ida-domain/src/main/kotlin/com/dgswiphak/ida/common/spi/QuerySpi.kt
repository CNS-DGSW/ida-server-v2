package com.dgswiphak.ida.common.spi

interface QuerySpi<T, ID> {
    fun findById(id: ID): T?
}