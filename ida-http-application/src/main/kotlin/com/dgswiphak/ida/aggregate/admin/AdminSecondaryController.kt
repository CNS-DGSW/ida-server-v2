package com.dgswiphak.ida.aggregate.admin

import com.dgswiphak.ida.common.excel.resource.sheet.OneSheetExcelFile
import com.dgswiphak.ida.domain.admin.dto.SecondaryTableResponse
import com.dgswiphak.ida.domain.admin.dto.excel.AptitudeExcel
import com.dgswiphak.ida.domain.admin.dto.excel.InterviewExcel
import com.dgswiphak.ida.domain.admin.usecase.AdminSecondaryUseCase
import jakarta.servlet.http.HttpServletResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URLEncoder

@RestController
@RequestMapping("/admin/secondary")
class AdminSecondaryController(
    private val adminSecondaryUseCase: AdminSecondaryUseCase
) {

    @GetMapping("/table")
    fun secondaryTable(): List<SecondaryTableResponse> {
        return adminSecondaryUseCase.getSecondaryTable()
    }

    @GetMapping("/aptitude/excel/download")
    fun aptitudeExcelDownload(response: HttpServletResponse) {
        val aptitudeExcel = adminSecondaryUseCase.jobExcelDownload()
        val excelFile: OneSheetExcelFile<AptitudeExcel> = OneSheetExcelFile(aptitudeExcel, AptitudeExcel::class.java)
        val name = URLEncoder.encode("직무적성.xlsx","UTF-8")
        response.contentType = "ms-vnd/excel"
        response.setHeader("Content-Disposition", "attachment;filename=$name")
        excelFile.write(response.outputStream)
    }

    @GetMapping("/interview/excel/download")
    fun interviewExcelDownload(response: HttpServletResponse) {
        val interviewExcel = adminSecondaryUseCase.interviewExcelDownload()
        val excelFile: OneSheetExcelFile<InterviewExcel> = OneSheetExcelFile(interviewExcel, InterviewExcel::class.java)
        val name = URLEncoder.encode("심층면접.xlsx","UTF-8")
        response.contentType = "ms-vnd/excel"
        response.setHeader("Content-Disposition", "attachment;filename=freeBoard.xlsx")
        excelFile.write(response.outputStream)
    }
}