package com.example.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

fun Application.configureRouting() {
    routing {
        get("/") {
            val res=user(25,"xxx","xxx@gmail.com")
            call.respond(res)
        }

        post("/login") {
            val res= call.receive<user>()
            println(res)
            call.respondText("this is a post request")
        }
    }
}
@Serializable
data class user(val id:Int,val name:String,val email:String)