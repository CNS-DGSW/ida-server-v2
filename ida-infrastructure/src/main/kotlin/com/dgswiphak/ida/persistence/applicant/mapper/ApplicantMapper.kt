package com.dgswiphak.ida.persistence.applicant.mapper

import com.dgswiphak.ida.common.embbed.EmbeddedMemberId
import com.dgswiphak.ida.common.model.MemberId
import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.common.util.MapperUtils
import com.dgswiphak.ida.domain.applicant.domain.Applicant
import com.dgswiphak.ida.domain.applicant.domain.value.education.Education
import com.dgswiphak.ida.domain.applicant.domain.value.education.value.Teacher
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.Privacy
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.Address
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.Merit
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.Parent
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.SchoolCode
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
class ApplicantMapper : Mapper<Applicant, ApplicantEntity> {

    private val infoMapper = InformationMapper()
    private val educationMapper = EducationMapper()

    override fun toDomain(entity: ApplicantEntity?): Applicant {
        return Applicant(
            id = MemberId(entity!!.id.value),
            privacy = (if(entity.privacy == null) Privacy() else infoMapper.toDomain(entity.privacy)),
            education = ((if (entity.education == null) Education() else educationMapper.toDomain(entity.education))!!)
        )
    }

    override fun toEntity(domain: Applicant): ApplicantEntity {
        return ApplicantEntity(
            id = EmbeddedMemberId.of(domain.id.value),
            privacy = MapperUtils.convertToEntityIsNull(domain.privacy, infoMapper),
            education = MapperUtils.convertToEntityIsNull(domain.education, educationMapper)
        )
    }


    inner class InformationMapper : Mapper<Privacy, EmbeddedPrivacy> {
        private val addressMapper = AddressMapper()
        private val parentMapper = ParentMapper()
        override fun toDomain(entity: EmbeddedPrivacy?): Privacy {
            return Privacy(
                name = entity!!.name,
                birth = entity.birth,
                gender = entity.gender,
                phone = entity.phone,
                photo = entity.photo,
                school = SchoolCode(entity.school?.code),
                address = addressMapper.toDomain(entity.address),
                parent = parentMapper.toDomain(entity.parent),
                merit = Merit(entity.merit?.code)
            )
        }

        override fun toEntity(domain: Privacy): EmbeddedPrivacy {
            return EmbeddedPrivacy(
                name = domain.name,
                birth = domain.birth,
                gender = domain.gender,
                phone = domain.phone,
                photo = domain.photo,
                school = (if (MapperUtils.isNull(domain.school)) null else SchoolCodeVO.of(domain.school?.code)),
                address = (MapperUtils.convertToEntityIsNull(domain.address, addressMapper)),
                parent = (MapperUtils.convertToEntityIsNull(domain.parent, parentMapper)),
                merit = (if (MapperUtils.isNull(domain.merit)) null else MeritVO.of(domain.merit?.code))
            )
        }
    }


    inner class AddressMapper : Mapper<Address, AddressVO> {
        override fun toDomain(entity: AddressVO?): Address? {
            return entity?.let {
                Address(
                    it.detailAddress,
                    it.streetAddress,
                    it.zipCode
                )
            }
        }

        override fun toEntity(domain: Address): AddressVO {
            return AddressVO(
                domain.detailAddress,
                domain.streetAddress,
                domain.zipCode
            )
        }
    }

    inner class ParentMapper : Mapper<Parent, ParentVO> {
        override fun toDomain(entity: ParentVO?): Parent? {
            return entity?.let {
                Parent(
                    name = it.name,
                    relation = it.relation,
                    phone = it.phoneNumber,
                    brith = it.brith
                )
            }
        }

        override fun toEntity(domain: Parent): ParentVO {
            return ParentVO(
                name = domain.name,
                relation = domain.relation,
                phoneNumber = domain.phone,
                brith = domain.brith
            )
        }
    }

    inner class EducationMapper: Mapper<Education, EmbeddedEducation> {

        private val teacherMapper = TeacherMapper()
        private val schoolMapper = SchoolMapper()

        override fun toDomain(entity: EmbeddedEducation?): Education? {
            return entity?.let {
                Education(
                    school = schoolMapper.toDomain(entity.school),
                    teacher = teacherMapper.toDomain(entity.teacher),
                    graduationType = it.graduationType,
                    graduateYear = it.graduateYear
                )
            }
        }

        override fun toEntity(domain: Education): EmbeddedEducation {
            return EmbeddedEducation(
                school = (MapperUtils.convertToEntityIsNull(domain.school, schoolMapper)),
                teacher = (MapperUtils.convertToEntityIsNull(domain.teacher, teacherMapper)),
                graduationType = domain.graduationType,
                graduateYear = domain.graduateYear
            )
        }

        inner class TeacherMapper : Mapper<Teacher, TeacherVO> {
            override fun toDomain(entity: TeacherVO?): Teacher? {
                return entity?.let {
                    Teacher(
                        name = it.name,
                        contact = it.contact
                    )
                }
            }

            override fun toEntity(domain: Teacher): TeacherVO {
                return TeacherVO(
                    domain.name,
                    domain.contact
                )
            }

        }
    }
}