package ca.kovaro.shop.billing


import ca.kovaro.shop.billing.api.v1.resources.HistoryResource
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
final class HistoryConfig: ResourceConfig() {
    init {
        register(HistoryResource::class.java)
    }
}