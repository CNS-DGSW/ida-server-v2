package com.dgswiphak.ida.persistence.school.service

import com.dgswiphak.ida.common.property.NeisProperties
import com.dgswiphak.ida.domain.school.spi.service.SearchSchoolService
import com.dgswiphak.ida.common.fegin.neis.NeisClient
import com.dgswiphak.ida.domain.school.dto.response.NeisSchoolResponse
import com.dgswiphak.ida.domain.school.dto.response.SchoolResponse
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service

@Service
class SearchSchoolServiceImpl(
    private val neisClient: NeisClient,
    private val neisProperties: NeisProperties,
    private val objectMapper: ObjectMapper
): SearchSchoolService {
    override fun execute(state: String, q: String): List<SchoolResponse> {
        val stringResponse = neisClient.getSchoolInfo(neisProperties.key, q, "중학교", state)
        val response = objectMapper.readValue(stringResponse, NeisSchoolResponse::class.java)

        return response.schoolInfo
            ?.flatMap { it.row.orEmpty() }
            ?.map {
                SchoolResponse(
                    name = it.schoolName.orEmpty(),
                    state = it.state.orEmpty(),
                    code = it.standardSchoolCode.orEmpty()
                )
            }
            ?: emptyList()
    }
}