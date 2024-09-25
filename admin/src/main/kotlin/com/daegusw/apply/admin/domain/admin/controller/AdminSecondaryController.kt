package com.daegusw.apply.admin.domain.admin.controller

import com.daegusw.apply.admin.domain.admin.dto.SecondaryTableResponse
import com.daegusw.apply.admin.domain.admin.dto.excel.AptitudeExcel
import com.daegusw.apply.admin.domain.admin.dto.excel.InterviewExcel
import com.daegusw.apply.admin.domain.admin.service.AdminSecondaryService
import com.daegusw.apply.core.excel.resource.sheet.OneSheetExcelFile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URLEncoder
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/admin/secondary")
class AdminSecondaryController(
    private val adminSecondaryService: AdminSecondaryService
) {

    @GetMapping("/table")
    fun secondaryTable(): List<SecondaryTableResponse> {
        return adminSecondaryService.getSecondaryTable()
    }

    @GetMapping("/aptitude/excel/download")
    fun aptitudeExcelDownload(response: HttpServletResponse) {
        val aptitudeExcel = adminSecondaryService.jobExcelDownload()
        val excelFile: OneSheetExcelFile<AptitudeExcel> = OneSheetExcelFile(aptitudeExcel, AptitudeExcel::class.java)
        val name = URLEncoder.encode("직무적성.xlsx","UTF-8")
        response.contentType = "ms-vnd/excel"
        response.setHeader("Content-Disposition", "attachment;filename=$name")
        excelFile.write(response.outputStream)
    }

    @GetMapping("/interview/excel/download")
    fun interviewExcelDownload(response: HttpServletResponse) {
        val interviewExcel = adminSecondaryService.interviewExcelDownload()
        val excelFile: OneSheetExcelFile<InterviewExcel> = OneSheetExcelFile(interviewExcel, InterviewExcel::class.java)
        val name = URLEncoder.encode("심층면접.xlsx","UTF-8")
        response.contentType = "ms-vnd/excel"
        response.setHeader("Content-Disposition", "attachment;filename=freeBoard.xlsx")
        excelFile.write(response.outputStream)
    }
}