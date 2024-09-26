package com.daegusw.apply.notice.application.service

import com.daegusw.apply.notice.application.exception.AttachedNotFoundException
import com.daegusw.apply.notice.application.exception.NoticeNotFoundException
import com.daegusw.apply.notice.application.port.`in`.web.NoticeAttachedUseCase
import com.daegusw.apply.notice.application.port.out.aws.s3.AwsS3Port
import com.daegusw.apply.notice.application.port.out.persistence.CommandNoticePort
import com.daegusw.apply.notice.application.port.out.persistence.QueryNoticePort
import com.daegusw.apply.notice.domain.value.Attached
import org.springframework.stereotype.Service
import java.io.File

@Service
class NoticeAttachedService(
    private val awsS3Port: AwsS3Port,
    private val queryNoticeSpi: QueryNoticePort,
    private val commandNoticeSpi: CommandNoticePort
) : NoticeAttachedUseCase {

    override fun saveAttached(noticeId: Long, files: List<File>) {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw NoticeNotFoundException("해당 게시글이 존재 하지 않습니다.")

        var attached = notice.attached

        attached = attached?.plus(
            files.map { req ->
                Attached(
                    originalName = req.name,
                    filePath = awsS3Port.upload(
                        file = req
                    )
                )
            }
        )

        commandNoticeSpi.save(
            notice.copy(
                attached = attached
            )
        )
    }

    override fun deleteAttached(noticeId: Long, fileName: String) {
        val notice = queryNoticeSpi.findById(noticeId)
            ?: throw NoticeNotFoundException("해당 게시글이 존재 하지 않습니다.")

        val mutableAttached = notice.attached!!.toMutableList()

        val attached = notice.attached!!.firstOrNull {
            it.originalName == fileName
        } ?: throw AttachedNotFoundException("해당 첨부파일이 존재 하지 않습니다.")

        mutableAttached.remove(attached)

        awsS3Port.delete(attached.filePath)

        commandNoticeSpi.save(notice.copy(attached = mutableAttached.toList()))
    }
}