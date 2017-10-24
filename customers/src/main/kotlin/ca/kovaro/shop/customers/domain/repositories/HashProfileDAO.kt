package ca.kovaro.shop.customers.domain.repositories

import ca.kovaro.shop.customers.domain.models.Profile
import ca.kovaro.shop.customers.domain.models.ProfileAttrs
import org.springframework.stereotype.Component


@Component
object HashProfileDAO : ProfileDAO {
    private val store = mutableListOf<Profile>()

    init {
        // initialize some data
        store.add(Profile(1, hashMapOf(
                ProfileAttrs.FirstName to "John",
                ProfileAttrs.LastName to "Wayne",
                ProfileAttrs.PhoneNumber to "+213232323")))
        store.add(Profile(2, hashMapOf(
                ProfileAttrs.FirstName to "Marius",
                ProfileAttrs.LastName to "Kambire",
                ProfileAttrs.PhoneNumber to "+3(0)19238475")))
        store.add(Profile(3, hashMapOf(
                ProfileAttrs.FirstName to "Lucien",
                ProfileAttrs.LastName to "Freezer",
                ProfileAttrs.PhoneNumber to "034958678375")))
        store.add(Profile(4, hashMapOf(
                ProfileAttrs.FirstName to "Kakaruto",
                ProfileAttrs.LastName to "Son Goky",
                ProfileAttrs.PhoneNumber to "+17 48 58 40")))
    }

    override fun all(): List<Profile> {
       return store
    }

    override fun save(profile: Profile) {
        store.add(profile)
    }

    override fun get(id: Long): Profile? {
        return store.find { it.id == id }
    }
}
