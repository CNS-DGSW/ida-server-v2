package com.daegusw.apply.admin.controller

import com.daegusw.apply.admin.dto.FirstTableResponse
import com.daegusw.apply.admin.service.AdminFirstGradeService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/first")
class AdminFirstGradeController(
    private val adminFirstGradeService: AdminFirstGradeService
) {

    @GetMapping
    fun firstTable(): List<FirstTableResponse> {
        return adminFirstGradeService.getFirstTable()
    }
}