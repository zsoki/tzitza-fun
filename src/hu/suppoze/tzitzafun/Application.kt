package hu.suppoze.tzitzafun

import hu.suppoze.tzitzafun.template.TzitzaMainTemplate
import io.ktor.application.Application
import io.ktor.application.ApplicationCall
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.HttpsRedirect
import io.ktor.html.insert
import io.ktor.html.respondHtml
import io.ktor.http.ContentType
import io.ktor.network.tls.certificates.generateCertificate
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.commandLineEnvironment
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlinx.css.CSSBuilder
import kotlinx.css.Color
import kotlinx.css.LinearDimension
import kotlinx.css.body
import kotlinx.css.em
import kotlinx.css.margin
import kotlinx.css.padding
import kotlinx.css.properties.LineHeight
import kotlinx.css.px
import kotlinx.html.head
import kotlinx.html.link
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
                    link(rel = "stylesheet", href = "/style.css", type = "text/css")
                }
                insert(TzitzaMainTemplate()) {
                    title { +"TZITZA World" }
                }
            }
        }

        get("/style.css") {
            call.respondCss {
                body {
                    maxWidth = 650.px
                    margin(40.px, LinearDimension.auto)
                    padding(0.px, 10.px)
                    fontSize = LinearDimension("18px / 1.5")
                    fontFamily = """
                        -apple-system, BlinkMacSystemFont,
                        'avenir next', avenir,
                        'Segoe UI',
                        'lucida grande',
                        'helvetica neue', helvetica,
                        'Fira Sans',
                        roboto, noto,
                        'Droid Sans',
                        cantarell, oxygen, ubuntu,
                        'franklin gothic medium', 'century gothic',
                        'Liberation Sans',
                        sans-serif;
                        """.trimIndent()
                    color = Color("#444")
                }

                "h1, h2, h3" {
                    lineHeight = LineHeight("1.2")
                }
            }
        }
    }
}
