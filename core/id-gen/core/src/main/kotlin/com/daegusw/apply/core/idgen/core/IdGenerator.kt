package com.daegusw.apply.core.idgen.core

import org.springframework.stereotype.Component

@Component
interface IdGenerator<T> {
    fun generate(): T
}