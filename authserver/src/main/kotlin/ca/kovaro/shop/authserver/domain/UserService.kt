package ca.kovaro.shop.authserver.domain

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(private val dao: UserDAO,
                  private val encoder: BCryptPasswordEncoder): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return dao.findByUsername(username)
    }

    fun register(dto: UserDTO){
        val user = ShopUser(
                userId = UUID.randomUUID().toString(),
                username = dto.username,
                password = encoder.encode(dto.password)
        )
        dao.save(user)
    }
}