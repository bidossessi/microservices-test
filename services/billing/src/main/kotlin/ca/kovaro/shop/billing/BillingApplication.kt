package ca.kovaro.shop.billing

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BillingApplication

fun main(args: Array<String>) {
    SpringApplication.run(BillingApplication::class.java, *args)
}