package ca.kovaro.shop.authserver.domain

import org.springframework.data.jpa.repository.JpaRepository

interface UserDAO : JpaRepository<ShopUser, Long> {
    fun findByUsername(name: String): ShopUser
}