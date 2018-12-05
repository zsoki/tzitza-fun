package hu.suppoze.tzitzafun

import hu.suppoze.tzitzafun.template.TzitzaMainTemplate
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.html.insert
import io.ktor.html.respondHtml
import io.ktor.routing.get
import io.ktor.routing.routing
import kotlinx.html.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    routing {
        get("/") {
            call.respondHtml {
                head {
                    title { +"TZITZA World" }
                }
                insert(TzitzaMainTemplate()) {
                    welcomeMessage { +"=OwO= What's this? ^^" }
                }
            }
        }
    }
}

