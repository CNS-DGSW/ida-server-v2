package com.daegusw.apply.applicant.smtp.adapter

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.ses.SesClient
import aws.sdk.kotlin.services.ses.model.*
import com.daegusw.apply.applicant.application.port.out.smtp.SmtpPort
import com.daegusw.apply.applicant.smtp.adapter.common.ApplicantStmpProperties
import org.springframework.stereotype.Component
import org.thymeleaf.context.Context
import org.thymeleaf.spring5.SpringTemplateEngine

@Component
class SmtpAdapter(
    private val applicantStmpProperties: ApplicantStmpProperties,
    private val templateEngine: SpringTemplateEngine,
    ) : SmtpPort {
    override suspend fun send(e: String) : String {
        try{
            val code = (1..5).map { (0..9).random() }.joinToString("")
            val context = Context()
            context.setVariable("code", code)

            val emailRequest = SendEmailRequest {
                destination = Destination {
                    toAddresses = listOf(e)
                }

                message = Message {
                    subject = Content {
                        data = "인증 번호"
                    }

                    body = Body {
                        html = Content {
                            data = templateEngine.process("code", context)
                        }
                    }
                }

                source = applicantStmpProperties.sendEmail
            }

            SesClient {
                region = applicantStmpProperties.region

                credentialsProvider = StaticCredentialsProvider {
                    accessKeyId = applicantStmpProperties.accessKey
                    secretAccessKey = applicantStmpProperties.secretKey
                }
            }.use {
                it.sendEmail(emailRequest)
            }
            return code
        }catch (e:Exception){
            throw RuntimeException()
        }
    }

}