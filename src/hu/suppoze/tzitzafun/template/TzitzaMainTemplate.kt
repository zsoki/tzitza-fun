package hu.suppoze.tzitzafun.template

import hu.suppoze.tzitzafun.styleCss
import io.ktor.html.Placeholder
import io.ktor.html.Template
import io.ktor.html.insert
import kotlinx.css.Float
import kotlinx.css.VerticalAlign
import kotlinx.css.pct
import kotlinx.css.px
import kotlinx.html.HTML
import kotlinx.html.PhrasingContent
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.h1
import kotlinx.html.h2
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.ul

class TzitzaMainTemplate : Template<HTML> {
    val title = Placeholder<PhrasingContent>()

    override fun HTML.apply() {
        body {
            h2 {
                attributes["align"] = "center"
                insert(title)
            }
            div("content-parent") {
                styleCss {
                    maxWidth = 800.px
                }

                div("sidebar-menu") {
                    styleCss {
                        float = Float.left
                        width = 20.pct
                        verticalAlign = VerticalAlign.top
                    }

                    ul {
                        li { +"Home" }
                        li { +"Posts" }
                    }
                }

                div("post-content") {
                    styleCss {
                        float = Float.left
                        width = 80.pct
                    }
                    h1 { +"Post title" }
                    p {
                        +"""Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Cursus sit amet dictum sit. Dignissim enim sit amet venenatis urna cursus eget. Pellentesque id nibh tortor id aliquet lectus. Velit dignissim sodales ut eu sem. Ipsum dolor sit amet consectetur adipiscing elit duis. Viverra maecenas accumsan lacus vel facilisis volutpat. Habitant morbi tristique senectus et netus et malesuada. Maecenas volutpat blandit aliquam etiam erat velit. Nullam eget felis eget nunc lobortis mattis aliquam faucibus purus. Magna fringilla urna porttitor rhoncus dolor purus. Eu lobortis elementum nibh tellus molestie. Sed viverra tellus in hac habitasse platea dictumst vestibulum. Vel risus commodo viverra maecenas accumsan. Mattis vulputate enim nulla aliquet porttitor lacus luctus.

Sed viverra tellus in hac habitasse. Ac orci phasellus egestas tellus rutrum tellus pellentesque. Leo vel orci porta non pulvinar neque. Venenatis tellus in metus vulputate. Aliquet lectus proin nibh nisl condimentum id venenatis. Mi bibendum neque egestas congue quisque egestas diam in arcu. Et malesuada fames ac turpis egestas. Vulputate odio ut enim blandit volutpat maecenas volutpat blandit aliquam. Adipiscing commodo elit at imperdiet dui accumsan sit amet nulla. Amet porttitor eget dolor morbi. Enim nulla aliquet porttitor lacus. Duis tristique sollicitudin nibh sit amet commodo nulla facilisi nullam. Praesent tristique magna sit amet purus gravida quis blandit turpis. Mi quis hendrerit dolor magna eget est.

Ullamcorper a lacus vestibulum sed arcu non odio. Ac auctor augue mauris augue neque. Dignissim suspendisse in est ante in nibh. Urna cursus eget nunc scelerisque viverra mauris in aliquam. Condimentum mattis pellentesque id nibh tortor. Posuere morbi leo urna molestie at elementum. Turpis egestas sed tempus urna et. Vitae justo eget magna fermentum iaculis eu non diam. Eu feugiat pretium nibh ipsum consequat nisl. Nunc sed id semper risus in.

Dictum varius duis at consectetur lorem. Eget arcu dictum varius duis. Nisl purus in mollis nunc sed id. Quam viverra orci sagittis eu. Faucibus scelerisque eleifend donec pretium vulputate sapien nec sagittis. Malesuada bibendum arcu vitae elementum curabitur vitae nunc sed. Erat nam at lectus urna duis convallis convallis. Nibh tellus molestie nunc non blandit massa enim nec. Blandit cursus risus at ultrices mi tempus. Sagittis purus sit amet volutpat consequat mauris. Senectus et netus et malesuada fames. Eu non diam phasellus vestibulum lorem sed risus ultricies tristique.

Volutpat diam ut venenatis tellus in metus vulputate eu. Dignissim enim sit amet venenatis urna cursus eget. Tortor id aliquet lectus proin nibh nisl condimentum. Fermentum iaculis eu non diam phasellus vestibulum lorem. Enim tortor at auctor urna. Duis ultricies lacus sed turpis tincidunt. Non quam lacus suspendisse faucibus interdum posuere. Faucibus pulvinar elementum integer enim. Feugiat pretium nibh ipsum consequat nisl vel. Purus in mollis nunc sed id semper risus. Arcu cursus euismod quis viverra nibh. Habitant morbi tristique senectus et netus et malesuada.""".trim()
                    }
                }
            }
        }
    }
}