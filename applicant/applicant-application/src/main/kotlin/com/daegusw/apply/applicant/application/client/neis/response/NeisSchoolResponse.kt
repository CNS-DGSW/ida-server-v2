package com.daegusw.apply.applicant.application.client.neis.response

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

data class NeisSchoolResponse(
    @get:JsonIgnoreProperties(ignoreUnknown = true)
    val schoolInfo: List<SchoolInfo>?
) {
    data class SchoolInfo(
        val head: List<Head>?,
        val row: List<Row>?
    ) {
        data class Head(
            @JsonProperty("list_total_count")
            val listTotalCount: Int,
            @JsonProperty("RESULT")
            val result: RESULT?
        ) {
            data class RESULT(
                @JsonProperty("CODE")
                val code: String?,
                @JsonProperty("MESSAGE")
                val message: String?
            )
        }
    }

    data class Row(
        @JsonProperty("ATPT_OFCDC_SC_CODE")
        val officeCode: String?,
        @JsonProperty("ATPT_OFCDC_SC_NM")
        val officeName: String?,
        @JsonProperty("SD_SCHUL_CODE")
        val standardSchoolCode: String?,
        @JsonProperty("SCHUL_NM")
        val schoolName: String?,
        @JsonProperty("ENG_SCHUL_NM")
        val englishSchoolName: String?,
        @JsonProperty("SCHUL_KND_SC_NM")
        val kindOfSchool: String?,
        @JsonProperty("LCTN_SC_NM")
        val state: String?,
        @JsonProperty("JU_ORG_NM")
        val origin: String?,
        @JsonProperty("FOND_SC_NM")
        val foundation: String?,
        @JsonProperty("ORG_RDNZC")
        val zoneCode: String?,
        @JsonProperty("ORG_RDNMA")
        val address: String?,
        @JsonProperty("ORG_RDNDA")
        val detailAddress: String?,
        @JsonProperty("ORG_TELNO")
        val tellNumber: String?,
        @JsonProperty("HMPG_ADRES")
        val homePageUrl: String?,
        @JsonProperty("COEDU_SC_NM")
        val genderType: String?,
        @JsonProperty("ORG_FAXNO")
        val faxNumber: String?,
        @JsonProperty("HS_SC_NM")
        val highSchoolType: String?,
        @JsonProperty("INDST_SPECL_CCCCL_EXST_YN")
        val isIndustrySpecialClassExist: String?,
        @JsonProperty("HS_GNRL_BUSNS_SC_NM")
        val highSchoolGeneralOrBusiness: String?,
        @JsonProperty("SPCLY_PURPS_HS_ORD_NM")
        val specialPurposeHighSchoolOrder: String?,
        @JsonProperty("ENE_BFE_SEHF_SC_NM")
        val admissionTimeType: String?,
        @JsonProperty("DGHT_SC_NM")
        val dayAndNightType: String?,
        @JsonProperty("FOND_YMD")
        val foundationDate: String?,
        @JsonProperty("FOAS_MEMRD")
        val schoolAnniversaryDate: String?,
        @JsonProperty("LOAD_DTM")
        val loadDateTime: String?
    )
}