package ca.kovaro.shop.billing.api.v1.resources

import ca.kovaro.shop.billing.api.v1.ampq.AMQPSender
import ca.kovaro.shop.billing.domain.models.InPurchaseDTO
import ca.kovaro.shop.billing.domain.services.purchase.PurchaseService
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/v1/purchase/{id}")
class PurchaseResource(val service: PurchaseService, val publisher: AMQPSender) {


    @PostMapping
    fun create(@PathVariable id: Long, @RequestBody dto: InPurchaseDTO) = service.create(id, dto)

    @GetMapping
    fun all(@PathVariable id: Long) = service.all(id)

    @GetMapping("/pending")
    fun pending(@PathVariable id: Long) = service.pending(id)

    @GetMapping("/valid")
    fun valid(@PathVariable id: Long) = service.validated(id)

    @PostMapping("/confirm/{uid}")
    fun confirm(@PathVariable uid: UUID) = service.confirm(uid)


    @GetMapping("/test")
    fun sendMsg(@RequestParam("msg") msg: String): String {
        publisher.produceMsg(msg)
        return "Done"
    }

}