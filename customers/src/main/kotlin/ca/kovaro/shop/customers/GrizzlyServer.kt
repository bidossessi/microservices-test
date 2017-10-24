package ca.kovaro.shop.customers

import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI

object GrizzlyServer {
    private val BASE_URI: String  = "http://0.0.0.0:8000/"

    @JvmStatic
    fun main(args: Array<String>){

        val resourceConfig: ResourceConfig = CustomerApplication.createApp()
        val server:HttpServer = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), resourceConfig)

        Runtime.getRuntime().addShutdownHook(Thread(Runnable {
            server.shutdownNow()
        }))
    }
}