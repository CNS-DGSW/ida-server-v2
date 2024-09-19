package com.daegusw.apply.admission.application.common.exception

import com.daegusw.apply.member.id.MemberId

class AdmissionDoesNotExistException(memberId: MemberId) : RuntimeException(
    "cannot find member ${memberId}'s admission"
) {
    @Synchronized
    override fun fillInStackTrace(): Throwable {
        return this
    }
}