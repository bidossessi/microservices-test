package ca.kovaro.shop.customers

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class CustomersApplication

fun main(args: Array<String>) {
    SpringApplication.run(CustomersApplication::class.java, *args)
}
