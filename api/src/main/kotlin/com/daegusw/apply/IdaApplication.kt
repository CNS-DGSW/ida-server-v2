package com.daegusw.apply

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class IdaApplication

fun main(args: Array<String>) {
    runApplication<IdaApplication>(*args)
}
