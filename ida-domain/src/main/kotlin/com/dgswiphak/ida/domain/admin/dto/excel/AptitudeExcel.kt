package com.dgswiphak.ida.domain.admin.dto.excel

import com.dgswiphak.ida.common.annotation.DefaultBodyStyle
import com.dgswiphak.ida.common.annotation.DefaultHeaderStyle
import com.dgswiphak.ida.common.annotation.ExcelColumn
import com.dgswiphak.ida.common.annotation.ExcelColumnStyle
import com.dgswiphak.ida.domain.applicant.model.Applicant
import com.dgswiphak.ida.domain.secondary.model.Secondary

@DefaultHeaderStyle(style = ExcelColumnStyle("com.dgswiphak.ida.common.excel.style.DefaultHeaderCellStyle"))
@DefaultBodyStyle(style = ExcelColumnStyle("com.dgswiphak.ida.common.excel.style.DefaultBodyCellStyle"))
data class AptitudeExcel(
    @ExcelColumn(headerName = "순번", width = 2000)
    val index: Int,
    @ExcelColumn(headerName = "접수 번호", width = 3000)
    val submitNumber: Int? = 0,
    @ExcelColumn(headerName = "수험 번호", width = 3000)
    val examNumber: Int? = 0,
    @ExcelColumn(headerName = "성명", width = 2000)
    val name: String? = "",
    @ExcelColumn(headerName = "직무적성 소양평가", width = 4000)
    val score: Double? = 0.0
) {

    constructor(index: Int, applicant: Applicant?, secondary: Secondary?) : this(
        index = index,
        name = applicant?.privacy?.name,
        score = secondary?.aptitude?.jopScore
    )
}