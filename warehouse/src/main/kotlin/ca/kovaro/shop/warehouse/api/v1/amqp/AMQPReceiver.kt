package ca.kovaro.shop.warehouse.api.v1.amqp

import ca.kovaro.shop.warehouse.domain.models.InPickingDTO
import ca.kovaro.shop.warehouse.domain.services.picking.PickingService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component


@Component
class AMQPReceiver(val service: PickingService) {

    // We've set up this queue to only listen for "purchase.validated" events
    @RabbitListener(queues = arrayOf("\${warehouse.rabbitmq.queue}"))
    fun getPicking(dto: InPickingDTO) {
        println("Picking Request: " + dto)
        service.create(dto)
    }
}