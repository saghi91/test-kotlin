package server

import org.apache.log4j.PropertyConfigurator
import org.glassfish.grizzly.http.server.HttpServer
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import user.UserResouce
import java.io.FileInputStream
import java.util.*
import javax.ws.rs.ProcessingException
import javax.ws.rs.core.UriBuilder



fun main() {
    val props = Properties()
    props.load(FileInputStream("src/log4j.properties"))
    PropertyConfigurator.configure(props)

    val host = "localhost"
    val port = 8080
    val baseUri = UriBuilder.fromUri("http://$host/").port(port).build()
    val server: HttpServer = GrizzlyHttpServerFactory.createHttpServer(baseUri, createConfiguration())
    try {
        server.start()
        println("REST Server Address: $host:$port")
    } catch (ex: ProcessingException) {
        println("Server Error: ${ex.message}")
        println("Exiting REST server...")
        server.shutdown()
    }
}


private fun createConfiguration(): ResourceConfig {
    return ResourceConfig(UserResouce::class.java)
}
