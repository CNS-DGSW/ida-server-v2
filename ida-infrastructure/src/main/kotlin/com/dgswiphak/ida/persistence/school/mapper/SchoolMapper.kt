package com.dgswiphak.ida.persistence.school.mapper

import com.dgswiphak.ida.common.mapper.Mapper
import com.dgswiphak.ida.domain.applicant.domain.value.privacy.value.SchoolCode
import com.dgswiphak.ida.domain.school.model.School
import com.dgswiphak.ida.persistence.applicant.entity.value.privacy.value.SchoolCodeVO
import com.dgswiphak.ida.persistence.school.entity.SchoolEntity
import org.springframework.stereotype.Component

@Component
class SchoolMapper: Mapper<School, SchoolEntity> {
    override fun toDomain(entity: SchoolEntity?): School? {
        return entity?. let {
            School(
                id = it.id,
                name = it.name,
                state = it.state,
                city = it.city,
                code = SchoolCode.of(it.code.code),
                contact = it.contact
            )
        }
    }

    override fun toEntity(domain: School): SchoolEntity {
        return SchoolEntity(
            id = domain.id,
            name = domain.name,
            state = domain.state,
            city = domain.city,
            code = SchoolCodeVO(domain.code.code),
            contact = domain.contact
        )
    }
}