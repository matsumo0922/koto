package me.matsumo.koto.core.repository.translator

import io.ktor.client.HttpClient
import io.ktor.client.request.headers
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.Serializable
import me.matsumo.koto.core.common.suspendRunCatching
import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.repository.di.formatter

class GoogleTranslator(
    private val client: HttpClient,
    private val apiKey: String,
) : Translator {

    override suspend fun translate(source: Language, target: Language, text: String): String {
        require(apiKey.isNotBlank()) { "API key was not provided." }

        val response = client.post {
            url(ENDPOINT)
            headers {
                append("Content-Type", "application/json; charset=utf-8")
                append("X-goog-api-key", apiKey)
            }
            setBody(
                Body(
                    q = text,
                    source = source.locale.language.takeUnless { source == Language.AUTO }.orEmpty(),
                    target = target.locale.language,
                )
            )
        }.bodyAsText()

        suspendRunCatching { formatter.decodeFromString(Response.serializer(), response) }.onSuccess {
            return it.data.translations.first().translatedText
        }

        error(response)
    }

    @Serializable
    private data class Body(
        val q: String,
        val source: String,
        val target: String,
        val format: String = "text",
    )

    @Serializable
    private data class Response(
        val data: Data,
    ) {
        @Serializable
        data class Data(
            val translations: List<Translation>,
        ) {
            @Serializable
            data class Translation(
                val translatedText: String,
                val detectedSourceLanguage: String,
            )
        }
    }

    companion object {
        private const val ENDPOINT = "https://translation.googleapis.com/language/translate/v2"
    }
}
