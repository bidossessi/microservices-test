package ca.kovaro.shop.billing

import org.springframework.amqp.core.*
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer






@SpringBootApplication
class BillingApplication {

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

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(queue).to(exchange).with("purchase.*")
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
    SpringApplication.run(BillingApplication::class.java, *args)
}
