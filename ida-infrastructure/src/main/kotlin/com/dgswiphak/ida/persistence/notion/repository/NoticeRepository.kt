package com.dgswiphak.ida.persistence.notion.repository

import com.dgswiphak.ida.persistence.notion.entity.NoticeEntity
import org.springframework.data.repository.CrudRepository

interface NoticeRepository: CrudRepository<NoticeEntity, Long>