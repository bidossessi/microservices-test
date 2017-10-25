package ca.kovaro.shop.authserver

import ca.kovaro.shop.authserver.domain.UserDTO
import ca.kovaro.shop.authserver.domain.UserService
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/users")
class UserResource(private val service: UserService) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody dto: UserDTO) = service.register(dto)


}
