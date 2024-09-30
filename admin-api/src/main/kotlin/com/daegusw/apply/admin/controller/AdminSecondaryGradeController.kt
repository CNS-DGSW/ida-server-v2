package com.daegusw.apply.admin.controller

import com.daegusw.apply.admin.dto.SecondaryTableResponse
import com.daegusw.apply.admin.dto.excel.AptitudeExcel
import com.daegusw.apply.admin.dto.excel.InterviewExcel
import com.daegusw.apply.admin.service.AdminSecondaryGradeService
import com.daegusw.apply.core.excel.resource.sheet.OneSheetExcelFile
import com.daegusw.apply.core.file.setExcelContentDisposition
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/admin/secondary")
class AdminSecondaryGradeController(
    private val adminSecondaryGradeService: AdminSecondaryGradeService
) {

    @GetMapping("/table")
    fun secondaryTable(): List<SecondaryTableResponse> {
        return adminSecondaryGradeService.getSecondaryTable()
    }

    @GetMapping("/aptitude/excel/download")
    fun aptitudeExcelDownload(response: HttpServletResponse) {
        val aptitudeExcel = adminSecondaryGradeService.jobExcelDownload()

        response.setExcelContentDisposition("직무적성")
        OneSheetExcelFile(aptitudeExcel, AptitudeExcel::class.java).write(response.outputStream)
    }

    @GetMapping("/interview/excel/download")
    fun interviewExcelDownload(response: HttpServletResponse) {
        val interviewExcel = adminSecondaryGradeService.interviewExcelDownload()

        response.setExcelContentDisposition("심층면접")
        OneSheetExcelFile(interviewExcel, InterviewExcel::class.java).write(response.outputStream)
    }
}