package ca.kovaro.shop.billing.api.v1.resources

import ca.kovaro.shop.billing.domain.models.HistoryDTO
import ca.kovaro.shop.billing.domain.services.history.HistoryService
import ca.kovaro.shop.billing.domain.services.history.SimpleHistoryService
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.*

@RefreshScope
@RestController
@RequestMapping("/v1/history")
class HistoryResource(private val service: HistoryService = SimpleHistoryService()) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): HistoryDTO? {
        return service.get(id)
    }
}