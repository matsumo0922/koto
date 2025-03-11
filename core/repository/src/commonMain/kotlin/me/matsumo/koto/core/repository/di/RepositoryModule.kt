package me.matsumo.koto.core.repository.di

import kotlinx.serialization.json.Json
import me.matsumo.koto.core.repository.UserDataRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    single {
        Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
            coerceInputValues = true
            encodeDefaults = true
            explicitNulls = false
        }
    }

    singleOf(::UserDataRepository)
}
