package com.daegusw.apply.admission.domain.constant

enum class ApplyType(
    val value: String,
    val mainCategory: Category? = null,
    val subCategory: SubCategory? = null,
) {
    NONE("없음"),

    COMMON("일반 전형", Category.COMMON),

    MEISTER("마이스터인재전형", Category.SPECIAL),

    LOCAL_FIRST("지역우선전형", Category.SPECIAL),

    BASIC_LIVELIHOOD("국민기초생활수급자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    RELIANCE_RECIPIENTS("차상위자활대상자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    SECOND_HIGHEST_DEDUCTIBLE("차상위본인부담경감대상자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    DISABILITY_BENEFIT_RECIPIENTS("차상위장애수당대상자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    DISABILITY_PENSION_RECIPIENT("차상위장애연금대상자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    PRIORITY_CARE_RECIPIENT("차상위우선돌봄대상자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    EDUCATION_BENEFIT_RECIPIENT("교육급여수급자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    VETERANS("국가 보훈 대상자(유공자)", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    ONE_PARENT_PROTECT("한부모 가족 보호 대상자", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    HIGH_WELFARE_RECIPIENTS("차차상위 계층", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),
    FINANCIAL_PERSON("학교장이 추천한 경제적으로 어려운 학생", Category.SPECIAL, SubCategory.EQUALS_OPPORTUNITY),

    SPECIAL_TRAINING("특수교육대상자", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    NORTH_KOREAN_CHILD("북한이탈주민", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    MULTICULTURAL("다문화가정", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    CHILD_WELFARE("아동복지시설수용자", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    SOCIAL_TEEN_HOUSEHOLDER("소년소녀 가장", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    GRANDCHILDREN("조손가정 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    CIVIL_SERVANT_ON_DUTY("순직 공무원의 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    FAMILY_WITH_DISABILITIES("장애인(장애인 등록증 5급 이내) 가정 가족 구성원", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    FARMING_AND_FISHING("농어촌거주", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    SOLDIER_CHILD("직업군인 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    CIVIL_SERVANT_CHILD("경찰․소방․교정 공무원 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    INDUSTRIAL_ACCIDENT_CHILD("산업재해근로자 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    STREET_CLEANERS_CHILD("환경미화원 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    MAILMAN_CHILD("우편집배원 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    HAS_CULTURAL_HERITAGE("무형문화재보유자 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    ADOPTED_FAMILY("입양자녀ㆍ입양가족 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    MULTI_CHILD_FAMILIES("다자녀가정 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    ONE_PARENT("한부모가정 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),
    NO_PARENT("결손가정 자녀", Category.SPECIAL, SubCategory.SOCIAL_DIVERSITY),

    FOREIGN_EDUCATION("외국 교육 이수자", Category.EXCEPTIONAL),
    MIDDLE_SCHOOL_EDUCATION("중학 학력 인증자", Category.EXCEPTIONAL),
    NORTH_KOREAN_DEFECTORS("( 정원외 ) 북한 이탈 주민녀", Category.EXCEPTIONAL),
    FOREIGN_SCHOOL("( 정원외 ) 외국 학교 전학자", Category.EXCEPTIONAL);

    enum class Category {
        COMMON,
        SPECIAL,
        EXCEPTIONAL
    }

    enum class SubCategory {
        EQUALS_OPPORTUNITY,
        SOCIAL_DIVERSITY
    }
}
