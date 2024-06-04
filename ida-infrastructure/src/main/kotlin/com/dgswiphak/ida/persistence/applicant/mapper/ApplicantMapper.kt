package com.dgswiphak.ida.persistence.applicant.mapper

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.model.SchoolCode
import com.dgswiphak.ida.common.util.MapperUtils
import com.dgswiphak.ida.domain.applicant.model.Applicant
import com.dgswiphak.ida.domain.applicant.model.value.education.Education
import com.dgswiphak.ida.domain.applicant.model.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.model.value.privacy.Privacy
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Address
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Merit
import com.dgswiphak.ida.domain.applicant.model.value.privacy.value.Parent
import com.dgswiphak.ida.persistence.applicant.entity.ApplicantEntity
import com.dgswiphak.ida.persistence.applicant.entity.value.education.EmbeddedEducation
import com.dgswiphak.ida.persistence.applicant.entity.value.education.value.TeacherVO
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.EmbeddedPrivacy
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.AddressVO
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.MeritVO
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.ParentVO
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.SchoolCodeVO
import com.dgswiphak.ida.persistence.school.mapper.SchoolMapper
import org.springframework.stereotype.Component

@Component
class ApplicantMapper: Mapper<Applicant, ApplicantEntity> {
    private val privacyMapper: PrivacyMapper = PrivacyMapper()
    private val educationMapper: EducationMapper = EducationMapper()

    override fun toDomain(entity: ApplicantEntity?): Applicant? {
        return entity?.let {
            Applicant(
                id = MemberId(entity.id.value),
                privacy = privacyMapper.toDomain(entity.privacy)?: Privacy(),
                education = educationMapper.toDomain(entity.education)?: Education(),
            )
        }
    }

    override fun toEntity(domain: Applicant): ApplicantEntity {
        return ApplicantEntity(
            id =  EmbeddedMemberId(domain.id.value),
            privacy = MapperUtils.convertToEntityIsNull(domain.privacy, privacyMapper),
            education = MapperUtils.convertToEntityIsNull(domain.education, educationMapper),
        )
    }

    inner class PrivacyMapper: Mapper<Privacy, EmbeddedPrivacy> {
        private val addressMapper = AddressMapper()
        private val parentMapper = ParentMapper()
        private val meritMapper = MeritMapper()

        override fun toDomain(entity: EmbeddedPrivacy?): Privacy? {
            return entity?.let {
                Privacy(
                    name = it.name,
                    birth = entity.birth,
                    gender = entity.gender,
                    phone = entity.phone,
                    photo = entity.photo,
                    schoolCode = (if (MapperUtils.isNull(it.schoolCode)) null else SchoolCode(it.schoolCode!!.value)),
                    address = addressMapper.toDomain(entity.address),
                    parent = parentMapper.toDomain(entity.parent),
                    merit = meritMapper.toDomain(entity.merit)
                )
            }
        }

        override fun toEntity(domain: Privacy): EmbeddedPrivacy {
            return EmbeddedPrivacy(
                name = domain.name,
                birth = domain.birth,
                gender = domain.gender,
                phone = domain.phone,
                photo = domain.photo,
                schoolCode = (if (MapperUtils.isNull(domain.schoolCode)) null else SchoolCodeVO(domain.schoolCode!!.value)),
                address = MapperUtils.convertToEntityIsNull(domain.address, addressMapper),
                parent = MapperUtils.convertToEntityIsNull(domain.parent, parentMapper),
                merit = MapperUtils.convertToEntityIsNull(domain.merit, meritMapper)
            )
        }

        inner class AddressMapper: Mapper<Address, AddressVO> {
            override fun toDomain(entity: AddressVO?): Address? {
                return entity?.let {
                    Address(
                        detailAddress = it.detailAddress,
                        streetAddress = entity.streetAddress,
                        zipCode = entity.zipCode
                    )
                }
            }

            override fun toEntity(domain: Address): AddressVO {
                return AddressVO(
                    detailAddress = domain.detailAddress,
                    streetAddress = domain.streetAddress,
                    zipCode = domain.zipCode
                )
            }
        }

        inner class ParentMapper: Mapper<Parent, ParentVO> {
            override fun toDomain(entity: ParentVO?): Parent? {
                return entity?.let {
                    Parent(
                        name = it.name,
                        relation = entity.relation,
                        phone = entity.phone,
                        brith = entity.brith,
                    )
                }
            }

            override fun toEntity(domain: Parent): ParentVO {
                return ParentVO(
                    name = domain.name,
                    relation = domain.relation,
                    phone = domain.phone,
                    brith = domain.brith
                )
            }
        }

        inner class MeritMapper: Mapper<Merit, MeritVO> {
            override fun toDomain(entity: MeritVO?): Merit? {
                return entity?.let {
                    Merit(
                        code = it.code,
                    )
                }
            }

            override fun toEntity(domain: Merit): MeritVO {
                return MeritVO(
                    code = domain.code
                )
            }
        }

    }

    inner class EducationMapper: Mapper<Education, EmbeddedEducation> {
        private val schoolMapper = SchoolMapper()
        private val teacherMapper = TeacherMapper()

        override fun toDomain(entity: EmbeddedEducation?): Education? {
            return entity?.let {
                Education(
                    school = schoolMapper.toDomain(entity.school),
                    teacher = teacherMapper.toDomain(entity.teacher),
                    graduateYear = entity.graduateYear,
                    graduationType = entity.graduationType,
                )
            }

        }

        override fun toEntity(domain: Education): EmbeddedEducation {
            return EmbeddedEducation(
                school = MapperUtils.convertToEntityIsNull(domain.school, schoolMapper),
                teacher =  MapperUtils.convertToEntityIsNull(domain.teacher, teacherMapper),
                graduateYear = domain.graduateYear,
                graduationType = domain.graduationType,
            )
        }

        inner class TeacherMapper: Mapper<Teacher, TeacherVO> {
            override fun toDomain(entity: TeacherVO?): Teacher? {
                return entity?.let {
                    Teacher(
                        name = it.name,
                        contact = entity.contact
                    )
                }
            }

            override fun toEntity(domain: Teacher): TeacherVO {
                return TeacherVO(
                    name = domain.name,
                    contact = domain.contact
                )
            }
        }

    }

}