package me.matsumo.koto.core.repository

import me.matsumo.koto.core.datasource.UserDataStore
import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.domain.ThemeColorConfig
import me.matsumo.koto.core.domain.ThemeConfig
import me.matsumo.koto.core.domain.TranslationService

class UserDataRepository(
    private val userDataStore: UserDataStore,
) {
    val userData = userDataStore.userData

    suspend fun setKotoId(id: String) {
        userDataStore.setKotoId(id)
    }

    suspend fun setThemeConfig(themeConfig: ThemeConfig) {
        userDataStore.setThemeConfig(themeConfig)
    }

    suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig) {
        userDataStore.setThemeColorConfig(themeColorConfig)
    }

    suspend fun setTargetLanguage(language: Language) {
        userDataStore.setTargetLanguage(language)
    }

    suspend fun setSelectedTranslationService(translationService: TranslationService) {
        userDataStore.setSelectedTranslationService(translationService)
    }

    suspend fun setGoogleTranslateApiKey(apiKey: String) {
        userDataStore.setGoogleTranslateApiKey(apiKey)
    }

    suspend fun setDeeplApiKey(apiKey: String) {
        userDataStore.setDeeplApiKey(apiKey)
    }

    suspend fun setChatGptApiKey(apiKey: String) {
        userDataStore.setChatGptApiKey(apiKey)
    }

    suspend fun setStartup(isStartup: Boolean) {
        userDataStore.setStartup(isStartup)
    }

    suspend fun setShowRetranslation(isShowRetranslation: Boolean) {
        userDataStore.setShowRetranslation(isShowRetranslation)
    }
}
