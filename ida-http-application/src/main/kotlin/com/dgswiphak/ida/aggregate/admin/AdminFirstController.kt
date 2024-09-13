package com.dgswiphak.ida.aggregate.admin

import com.dgswiphak.ida.domain.admin.dto.FirstTableResponse
import com.dgswiphak.ida.domain.admin.usecase.AdminFirstUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/admin/first")
class AdminFirstController(
    val adminFirstUseCase: AdminFirstUseCase
) {

    @GetMapping("/table")
    fun firstTable() : List<FirstTableResponse> {
        return adminFirstUseCase.getFirstTable()
    }
}