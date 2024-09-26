package com.daegusw.apply.core.idgen.tsid

import com.daegusw.apply.core.idgen.core.IdGenerator
import com.github.f4b6a3.tsid.TsidFactory
import org.springframework.stereotype.Component

@Component
class TsidGenerator : IdGenerator<Long> {

    private val tsidFactory = TsidFactory.newInstance256()

    override fun generate(): Long {
        return tsidFactory.create().toLong()
    }

}