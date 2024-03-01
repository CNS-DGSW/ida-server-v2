package com.dgswiphak.ida.aggregate.school

import com.dgswiphak.ida.domain.school.dto.response.SchoolResponse
import com.dgswiphak.ida.domain.school.spi.service.SearchSchoolService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/school")
class SchoolController(
    private val searchSchoolService: SearchSchoolService
) {
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    fun searchSchool(
        @RequestParam("state") state: String,
        @RequestParam("q") q:String
    ): List<SchoolResponse> {
        return searchSchoolService.execute(state, q)
    }
}