package com.casadodev.plugins

import com.casadodev.application.StartBot
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*

fun Application.configureRouting() {

    StartBot.registerFeatures()
    StartBot.start()

    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Chatbot está online!")
        }
    }

}
