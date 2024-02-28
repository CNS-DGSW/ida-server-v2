package com.dgswiphak.ida.common.fegin.neis

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "neis", url = "https://open.neis.go.kr/hub")
interface NeisClient {
    @GetMapping("/schoolInfo?Type=json")
    fun getSchoolInfo(
        @RequestParam("Key") key: String,
        @RequestParam("SCHUL_NM") schoolName: String,
        @RequestParam(name = "SCHUL_KND_SC_NM", required = false) schoolType: String,
        @RequestParam(name = "LCTN_SC_NM") state: String
    ): String
}