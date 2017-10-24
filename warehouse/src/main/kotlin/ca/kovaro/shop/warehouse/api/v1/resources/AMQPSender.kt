package ca.kovaro.shop.warehouse.api.v1.resources

import ca.kovaro.shop.warehouse.domain.models.Picking
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component


@Component
class AMQPSender(val rabbitTemplate: RabbitTemplate,
                 val exchange: TopicExchange) {


    fun pickingCreated(picking: Picking){
        rabbitTemplate.convertAndSend(exchange.name, "picking.created", picking)
        println("New Picking = " + picking)
    }

}