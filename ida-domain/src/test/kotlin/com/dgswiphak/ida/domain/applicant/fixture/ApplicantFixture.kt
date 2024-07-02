package com.dgswiphak.ida.domain.applicant.fixture

import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.model.PhoneNumber
import com.dgswiphak.ida.common.model.Photo
import com.dgswiphak.ida.common.model.SchoolCode
import com.dgswiphak.ida.common.util.IdGenerator
import com.dgswiphak.ida.domain.applicant.model.Applicant
import com.dgswiphak.ida.domain.applicant.model.value.education.Education
import com.dgswiphak.ida.domain.applicant.model.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.model.value.education.value.type.GraduationType
import com.dgswiphak.ida.domain.applicant.model.value.privacy.Privacy
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Address
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Parent
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.type.Gender
import com.dgswiphak.ida.domain.school.createSchool
import java.time.LocalDate

internal fun createApplicant(
    id: MemberId = MemberId(IdGenerator.generateUUIDWithLong()),
    privacy: Privacy = Privacy(
        name = "아이다",
        birth = LocalDate.of(2010, 2, 11),
        gender = Gender.MALE,
        phone = PhoneNumber("01012345678"),
        photo = Photo("https://dgswapply.com/photo.png"),
        schoolCode = SchoolCode("0000000"),
        address = Address(
            streetAddress = "대구 달성군 구지면 창리로11길 93",
            detailAddress = "무인택배함 앞",
            zipCode = 43010
        ),
        parent = Parent(
            name = "나부모",
            relation = "부",
            phone = PhoneNumber("01012345678"),
            brith = LocalDate.of(1980, 3, 6)
        )
    ),
    education: Education = Education(
        school = createSchool(),
        teacher = Teacher(
            name = "나선생",
            contact = PhoneNumber("01012345678")
        ),
        graduationType = GraduationType.EXPECTED,
        graduateYear = 2025
    )
): Applicant = Applicant(
    id = id,
    privacy = privacy,
    education = education
)