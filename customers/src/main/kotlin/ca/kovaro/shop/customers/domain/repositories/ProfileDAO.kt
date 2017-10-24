package ca.kovaro.shop.customers.domain.repositories

import ca.kovaro.shop.customers.domain.models.Profile

interface ProfileDAO {
    fun all(): List<Profile>
    fun save(profile: Profile)
    fun get(id: Long): Profile?

}