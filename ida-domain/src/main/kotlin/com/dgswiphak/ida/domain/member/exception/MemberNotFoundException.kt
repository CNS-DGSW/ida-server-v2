package com.dgswiphak.ida.domain.member.exception

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.domain.member.exception.error.MemberErrorCode

object MemberNotFoundException : IdaException(
    MemberErrorCode.NOT_FOUND
)