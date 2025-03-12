package me.matsumo.koto.core.repository.di

import io.github.aakira.napier.Napier
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import me.matsumo.koto.core.repository.TranslationRepository
import me.matsumo.koto.core.repository.UserDataRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val formatter = Json {
    isLenient = true
    prettyPrint = true
    ignoreUnknownKeys = true
    coerceInputValues = true
    encodeDefaults = true
    explicitNulls = false
}

val repositoryModule = module {
    single {
        formatter
    }

    single {
        HttpClient {
            install(Logging) {
                level = LogLevel.INFO
                logger = object : io.ktor.client.plugins.logging.Logger {
                    override fun log(message: String) {
                        Napier.d(message)
                    }
                }
            }

            install(ContentNegotiation) {
                json(get<Json>())
            }
        }
    }

    singleOf(::UserDataRepository)
    singleOf(::TranslationRepository)
}
