package ca.kovaro.shop.warehouse

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class WarehouseApplication {

    @Value("\${jsa.rabbitmq.queue}")
    private val queueName: String = ""

    @Value("\${jsa.rabbitmq.exchange}")
    private val exchangeName: String = ""

    @Bean
    fun queue(): Queue {
        return Queue(queueName, false)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(exchangeName)
    }

    // We set up this queue to only listen for "purchase.validated" events
    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with("purchase.validated")
    }

    @Bean
    fun rabbitTemplate(connectionFactory: ConnectionFactory): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)
        rabbitTemplate.messageConverter = jsonConverter()
        return rabbitTemplate
    }

    @Bean
    fun jsonConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(WarehouseApplication::class.java, *args)
}
