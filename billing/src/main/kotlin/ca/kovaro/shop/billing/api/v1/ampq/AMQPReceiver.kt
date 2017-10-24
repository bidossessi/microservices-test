package ca.kovaro.shop.billing.api.v1.ampq

import org.springframework.stereotype.Component
import org.springframework.amqp.rabbit.annotation.RabbitListener


@Component
class AMQPReceiver {

    @RabbitListener(queues = arrayOf("\${billing.rabbitmq.queue}"))
    fun receivedMessage(msg: Any) {
        println("Received Message: " + msg)
    }
}