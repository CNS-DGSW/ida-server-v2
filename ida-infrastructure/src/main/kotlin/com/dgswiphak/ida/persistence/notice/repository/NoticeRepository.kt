package com.dgswiphak.ida.persistence.notice.repository

import com.dgswiphak.ida.persistence.notice.entity.NoticeEntity
import org.springframework.data.repository.CrudRepository

interface NoticeRepository: CrudRepository<NoticeEntity, Long>