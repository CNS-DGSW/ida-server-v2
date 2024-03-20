package com.dgswiphak.ida.domain.notice.exception

import com.dgswiphak.ida.common.error.IdaException
import com.dgswiphak.ida.domain.notice.exception.error.NoticeErrorCode

object AttachedNotFoundException: IdaException(
    NoticeErrorCode.NOT_FOUND_ATTACHED
)