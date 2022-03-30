package no.nav.tpts.mottak.clients

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.json.JsonFeature
import io.ktor.client.plugins.json.serializer.KotlinxSerializer
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.server.plugins.*
import kotlinx.serialization.json.Json

object HttpClient {
    val client = HttpClient(CIO) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.NONE
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json { ignoreUnknownKeys = true })
        }
    }
}
