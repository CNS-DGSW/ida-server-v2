package com.dgswiphak.ida.client.neis

import com.dgswiphak.ida.domain.school.dto.response.NeisSchoolResponse
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.HttpExchange

@HttpExchange(url = "https://open.neis.go.kr/hub")
interface NeisClient {
    @GetExchange("/schoolInfo?Type=json")
    fun getSchoolInfo(
        @RequestParam("Key") key: String,
        @RequestParam("SCHUL_NM") schoolName: String,
        @RequestParam(name = "SCHUL_KND_SC_NM", required = false) schoolType: String,
        @RequestParam(name = "LCTN_SC_NM") state: String
    ): String
}