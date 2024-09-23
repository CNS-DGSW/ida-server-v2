package com.daegusw.apply.applicant.application.common.exception

import com.daegusw.apply.member.id.MemberId

class ApplicantDoesNotExistException(memberId: MemberId) : RuntimeException(
    "cannot find member ${memberId}'s applicant"
)  {
    @Synchronized
    override fun fillInStackTrace(): Throwable {
        return this
    }
}