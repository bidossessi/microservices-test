package ca.kovaro.shop.customers

import ca.kovaro.shop.customers.api.v1.resources.ProfileResource
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import javax.ws.rs.core.Application
import javax.ws.rs.ext.ContextResolver


class CustomerApplication : Application() {
    override fun getClasses(): MutableSet<Class<*>> {
        return mutableSetOf(
                JacksonFeature::class.java,
                ProfileResource::class.java
        )
    }

    companion object {
        fun createApp(): ResourceConfig {
            return ResourceConfig.forApplication(
                    CustomerApplication()
            ).register(
                    ContextResolver<ObjectMapper> {
                        ObjectMapper().registerModule (KotlinModule())
                    }
            )
        }
    }
}