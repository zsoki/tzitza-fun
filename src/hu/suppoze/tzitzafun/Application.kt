package hu.suppoze.tzitzafun

import hu.suppoze.tzitzafun.template.TzitzaMainTemplate
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.HttpsRedirect
import io.ktor.html.insert
import io.ktor.html.respondHtml
import io.ktor.network.tls.certificates.generateCertificate
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.html.head
import kotlinx.html.title
import java.io.File

fun main(args: Array<String>) {
    val file = File("build/temporary.jks")
    if (!file.exists()) {
        file.parentFile.mkdirs()
        generateCertificate(file)
    }
    embeddedServer(Netty, commandLineEnvironment(args)).start()
}

@Suppress("unused")
fun Application.module() {
    install(HttpsRedirect) {
        sslPort = 8443
    }
    routing {
        get("/") {
            call.respondHtml {
                head {
                    title { +"TZITZA World" }
                }
                insert(TzitzaMainTemplate()) {
                    welcomeMessage { +"=OwO= What's this?" }
                }
            }
        }
    }
}

