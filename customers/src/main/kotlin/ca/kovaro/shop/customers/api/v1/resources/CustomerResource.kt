package ca.kovaro.shop.customers.api.v1.resources

import ca.kovaro.shop.customers.domain.models.ProfileDTO
import ca.kovaro.shop.customers.domain.services.ProfileService
import ca.kovaro.shop.customers.domain.services.SimpleProfileService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/profile")
class CustomerResource(private val service: ProfileService = SimpleProfileService()) {

    @GetMapping
    fun list():List<ProfileDTO> {
        return service.list()
    }

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): ProfileDTO? {
        return service.one(id)
    }
}