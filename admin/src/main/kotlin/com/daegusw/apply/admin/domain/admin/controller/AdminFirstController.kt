package com.daegusw.apply.admin.domain.admin.controller

import com.daegusw.apply.admin.domain.admin.dto.FirstTableResponse
import com.daegusw.apply.admin.domain.admin.service.AdminFirstService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/first")
class AdminFirstController(
    private val adminFirstService: AdminFirstService
) {

    @GetMapping
    fun firstTable(): List<FirstTableResponse> {
        return adminFirstService.getFirstTable()
    }
}