package ca.kovaro.shop.customers.domain.repositories

import ca.kovaro.shop.customers.domain.models.Profile

interface ProfileDAO {
    fun all(): List<Profile>
    fun create(profile: Profile): Boolean
    fun get(id: Long): Profile?
//    fun update(id: Long, attributes:HashMap<String, String>): Boolean
//    fun delete(id: Long): Boolean
}