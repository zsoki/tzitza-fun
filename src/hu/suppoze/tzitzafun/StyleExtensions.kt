package hu.suppoze.tzitzafun

import io.ktor.application.ApplicationCall
import io.ktor.http.ContentType
import io.ktor.response.respondText
import kotlinx.css.CSSBuilder
import kotlinx.html.CommonAttributeGroupFacade
import kotlinx.html.style

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}

inline fun CommonAttributeGroupFacade.styleCss(builder: CSSBuilder.() -> Unit) {
    this.style = CSSBuilder().apply(builder).toString()
}