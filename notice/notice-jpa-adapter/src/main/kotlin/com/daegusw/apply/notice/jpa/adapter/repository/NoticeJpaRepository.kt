package com.daegusw.apply.notice.jpa.adapter.repository

import com.dgswiphak.ida.persistence.notice.entity.NoticeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NoticeJpaRepository: JpaRepository<NoticeEntity, Long>