package ca.kovaro.shop.customers.domain.services

import ca.kovaro.shop.customers.domain.models.Profile
import ca.kovaro.shop.customers.domain.models.ProfileDTO
import java.time.Instant
import java.util.*

class DTOConverter {
    fun convertFrom(dto: ProfileDTO): Profile {
        return Profile(dto.id, dto.profile, updated_on = Date.from(Instant.now()))
    }
//    fun convertFrom(dtos: List<ProfileDTO>): List<Profile> {
//        return dtos.map { convertFrom(it) }
//    }

    fun convertTo(profile: Profile): ProfileDTO {
        return ProfileDTO(profile.id, profile.attributes)
    }

    fun convertTo(profiles: List<Profile>): List<ProfileDTO> {
        return profiles.map { convertTo(it) }
    }
}