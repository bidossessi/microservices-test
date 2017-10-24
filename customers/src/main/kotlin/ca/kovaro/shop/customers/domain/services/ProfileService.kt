package ca.kovaro.shop.customers.domain.services

import ca.kovaro.shop.customers.domain.models.ProfileDTO

interface ProfileService {
    fun list(): List<ProfileDTO>
    fun create(dto: ProfileDTO): Boolean
    fun one(id: Long): ProfileDTO?
}
