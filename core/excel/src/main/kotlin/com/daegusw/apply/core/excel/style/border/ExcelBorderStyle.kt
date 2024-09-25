package com.daegusw.apply.core.excel.style.border

import org.apache.poi.ss.usermodel.BorderStyle

enum class ExcelBorderStyle(
    val borderStyle: BorderStyle
) {

    NONE(BorderStyle.NONE),
    THIN(BorderStyle.THIN),
    MEDIUM(BorderStyle.MEDIUM),
    DASHED(BorderStyle.DASHED),
    DOTTED(BorderStyle.DOTTED),
    THICK(BorderStyle.THICK),
    DOUBLE(BorderStyle.DOUBLE),
    HAIR(BorderStyle.HAIR),
    MEDIUM_DASHED(BorderStyle.MEDIUM_DASHED),
    DASH_DOT(BorderStyle.DASH_DOT),
    MEDIUM_DASH_DOT(BorderStyle.MEDIUM_DASH_DOT),
    DASH_DOT_DOT(BorderStyle.DASH_DOT_DOT),
    MEDIUM_DASH_DOT_DOT(BorderStyle.MEDIUM_DASH_DOT_DOT),
    SLANTED_DASH_DOT(BorderStyle.SLANTED_DASH_DOT);
}
