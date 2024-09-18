package com.daegusw.apply.applicant.jpa.adapter.common

import com.daegusw.apply.applicant.domain.applicant.privacy.Privacy
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Address
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Merit
import com.daegusw.apply.applicant.domain.applicant.privacy.value.Parent
import com.daegusw.apply.core.data.entity.applicant.value.AddressVO
import com.daegusw.apply.core.data.entity.applicant.value.EmbeddedPrivacy
import com.daegusw.apply.core.data.entity.applicant.value.MeritVO
import com.daegusw.apply.core.data.entity.applicant.value.ParentVO

object PrivacyMapper {
    fun toEmbeddedPrivacy(privacy: Privacy): EmbeddedPrivacy {
        return EmbeddedPrivacy(
            name = privacy.name,
            birth = privacy.birth,
            gender = privacy.gender,
            phone = privacy.phone,
            photo = privacy.photo,
            address = privacy.address?.let { toAddressVO(it) },
            parent = privacy.parent?.let { toParentVO(it) },
            merit = privacy.merit?.let { toMeritVO(it) }
        )
    }

    fun toPrivacy(embedded: EmbeddedPrivacy?): Privacy? {
        return embedded?.let {
            Privacy(
                name = it.name,
                birth = embedded.birth,
                gender = embedded.gender,
                phone = embedded.phone,
                photo = embedded.photo,
                address = toAddress(embedded.address),
                parent = toParent(embedded.parent),
                merit = toMerit(embedded.merit)
            )
        }
    }


    private fun toAddressVO(address: Address): AddressVO {
        return AddressVO(
            detailAddress = address.detailAddress,
            streetAddress = address.streetAddress,
            zipCode = address.zipCode
        )
    }

    private fun toAddress(vo: AddressVO?): Address? {
        return vo?.let {
            Address(
                detailAddress = it.detailAddress,
                streetAddress = vo.streetAddress,
                zipCode = vo.zipCode
            )
        }
    }

    private fun toParentVO(parent: Parent): ParentVO {
        return ParentVO(
            name = parent.name,
            relation = parent.relation,
            phone = parent.phone,
            birth = parent.birth
        )
    }

    private fun toParent(vo: ParentVO?): Parent? {
        return vo?.let {
            Parent(
                name = it.name,
                relation = vo.relation,
                phone = vo.phone,
                birth = vo.birth
            )
        }
    }

    private fun toMeritVO(merit: Merit): MeritVO {
        return MeritVO(merit.code)
    }

    private fun toMerit(vo: MeritVO?): Merit? {
        return vo?.let { Merit(it.code) }
    }
}