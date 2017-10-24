package ca.kovaro.shop.customers.domain.models

import java.time.Instant
import java.util.*

enum class ProfileAttrs {
    FirstName,
    LastName,
    PhoneNumber,
}

data class Profile(val id: Long,
                   val attributes: HashMap<ProfileAttrs, String>,
                   val created_on: Date = Date.from(Instant.now()),
                   val updated_on: Date = Date.from(Instant.now()))

data class ProfileDTO(val id: Long, val profile: HashMap<ProfileAttrs, String>)