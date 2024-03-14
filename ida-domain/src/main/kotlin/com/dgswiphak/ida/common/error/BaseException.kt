package com.dgswiphak.ida.common.error

abstract class BaseException(
    val errorProperty: ErrorProperty
) : RuntimeException() {

}