package ca.kovaro.shop.authserver.domain

import org.hibernate.validator.constraints.Email
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
@Table(name = "users")
data class ShopUser(
        @Id
        @Column(name = "USER_ID", nullable = false, unique = true)
        val userId: String = "",

        @Column(name = "NAME", nullable = true, unique = true)
        private val username: String,

        @Column(name = "EMAIL", nullable = true, unique = true)
        val email: Email? = null,

        @Column(name = "PASSWORD", nullable = true)
        private val password: String,

        @Column(name = "ENABLED", nullable = false)
        private val enabled: Boolean = true,

        @Column(name = "PROVIDER", nullable = false)
        val provider: String = "LOCAL"

): UserDetails {
    override fun getUsername(): String {
        return username
    }

    override fun getPassword(): String {
        return password
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf<GrantedAuthority>()
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

}


data class UserDTO(val username: String, val password: String)