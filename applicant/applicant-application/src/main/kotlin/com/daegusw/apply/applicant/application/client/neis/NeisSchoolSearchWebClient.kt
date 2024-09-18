package com.daegusw.apply.applicant.application.client.neis

import com.daegusw.apply.applicant.application.common.dto.SchoolResponse
import com.daegusw.apply.applicant.application.client.neis.property.NeisProperties
import com.daegusw.apply.applicant.application.client.neis.response.NeisSchoolResponse
import com.daegusw.apply.applicant.application.port.out.client.SchoolSearchWebClientPort
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class NeisSchoolSearchWebClient(
    private val neisProperties: NeisProperties,
    private val objectMapper: ObjectMapper
) : SchoolSearchWebClientPort {
    override fun search(q: String): List<SchoolResponse> {
        val htmlResponse = WebClient.builder()
            .baseUrl("https://open.neis.go.kr/hub")
            .build()
            .get()
            .uri { uriBuilder ->
                uriBuilder
                    .path("/schoolInfo")
                    .queryParam("Type", "json")
                    .queryParam("pSize", 10)
                    .queryParam("Key", neisProperties.key)
                    .queryParam("SCHUL_NM", q)
                    .queryParam("SCHUL_KND_SC_NM", "중학교")
                    .build()
            }
            .retrieve()
            .bodyToMono(String::class.java)
            .block()

        val response = objectMapper.readValue(htmlResponse, NeisSchoolResponse::class.java)

        return response.schoolInfo
            ?.flatMap { it.row.orEmpty() }
            ?.map {
                SchoolResponse(
                    name = it.schoolName.orEmpty(),
                    state = it.state.orEmpty(),
                    address = it.address.orEmpty(),
                    code = it.standardSchoolCode.orEmpty()
                )
            } ?: emptyList()
    }
}