package com.daegusw.apply.admin.domain.admin.dto.excel

import com.daegusw.apply.admin.domain.secondary.domain.Secondary
import com.daegusw.apply.applicant.domain.applicant.Applicant
import com.daegusw.apply.core.excel.common.annotation.DefaultBodyStyle
import com.daegusw.apply.core.excel.common.annotation.DefaultHeaderStyle
import com.daegusw.apply.core.excel.common.annotation.ExcelColumn
import com.daegusw.apply.core.excel.common.annotation.ExcelColumnStyle
import com.daegusw.apply.core.excel.style.DefaultBodyCellStyle
import com.daegusw.apply.core.excel.style.DefaultHeaderCellStyle

@DefaultHeaderStyle(style = ExcelColumnStyle(excelCellStyleClass = DefaultHeaderCellStyle::class))
@DefaultBodyStyle(style = ExcelColumnStyle(excelCellStyleClass = DefaultBodyCellStyle::class))
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