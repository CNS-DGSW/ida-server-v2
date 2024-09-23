package com.daegusw.apply.memnber.application.common

class MemberDoesNotExistException(memberId: Long) : RuntimeException(
    "cannot find $memberId member"
)