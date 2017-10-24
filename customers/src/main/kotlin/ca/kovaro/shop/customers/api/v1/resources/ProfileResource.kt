package ca.kovaro.shop.customers.api.v1.resources

import ca.kovaro.shop.customers.domain.models.ProfileDTO
import ca.kovaro.shop.customers.domain.services.ProfileService
import ca.kovaro.shop.customers.domain.services.SimpleProfileService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType


@Path("/v1/profile")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class ProfileResource(private val service: ProfileService = SimpleProfileService()) {

    @GET
    fun list():List<ProfileDTO> {
        return service.list()
    }

    @GET
    @Path("{id}")
    fun get(@PathParam("id") id: Long): ProfileDTO? {
        return service.one(id)
    }
}