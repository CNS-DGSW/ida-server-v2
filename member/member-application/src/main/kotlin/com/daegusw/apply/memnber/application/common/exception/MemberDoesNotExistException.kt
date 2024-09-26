package com.daegusw.apply.memnber.application.common.exception

class MemberDoesNotExistException(memberId: Long) : RuntimeException(
    "cannot find $memberId member"
)