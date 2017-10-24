package ca.kovaro.shop.warehouse.api.v1.resources

import ca.kovaro.shop.warehouse.domain.services.picking.PickingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/picking")
class PickingResource(private val service: PickingService) {

    @GetMapping
    fun all() = service.all()
}