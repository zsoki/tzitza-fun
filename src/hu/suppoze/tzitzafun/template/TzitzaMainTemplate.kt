package hu.suppoze.tzitzafun.template

import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.html.HTML
import kotlinx.html.PhrasingContent
import kotlinx.html.body
import kotlinx.html.h1

class TzitzaMainTemplate : Template<HTML> {
    val welcomeMessage = Placeholder<PhrasingContent>()

    override fun HTML.apply() {
        body {
            h1 {
                attributes["align"] = "center"
                insert(welcomeMessage)
            }
        }
    }
}