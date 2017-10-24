package ca.kovaro.shop.billing.api.v1.ampq

import ca.kovaro.shop.billing.domain.models.Purchase
import org.springframework.stereotype.Component
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.core.RabbitTemplate


@Component
class AMQPSender(val rabbitTemplate: RabbitTemplate,
                 val exchange: TopicExchange) {

    fun produceMsg(msg: String) {
        rabbitTemplate.convertAndSend(exchange.name, "purchase.test", msg)
        println("Send msg = " + msg)
    }

    fun newPurchase(item: Purchase) {
        rabbitTemplate.convertAndSend(exchange.name, "purchase.created", item)
        println("New purchase " + item)
    }

    fun purchaseValidated(item: Purchase) {
        rabbitTemplate.convertAndSend(exchange.name, "purchase.validated", item)
        println("Purchase validated " + item)
    }
}