package ca.kovaro.shop.billing.api.v1.resources

import ca.kovaro.shop.billing.domain.models.HistoryDTO
import ca.kovaro.shop.billing.domain.services.HistoryService
import ca.kovaro.shop.billing.domain.services.SimpleHistoryService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/v1/history")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class HistoryResource(private val service: HistoryService = SimpleHistoryService()) {

    @GET
    @Path("{id}")
    fun get(@PathParam("id") id: Long): HistoryDTO? {
        return service.get(id)
    }
}