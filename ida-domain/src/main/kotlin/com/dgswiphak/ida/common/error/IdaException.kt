package com.dgswiphak.ida.common.error

abstract class IdaException(
    val errorProperty: ErrorProperty
) : RuntimeException()