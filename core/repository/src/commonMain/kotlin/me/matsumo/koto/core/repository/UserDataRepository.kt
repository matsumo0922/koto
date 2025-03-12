package me.matsumo.koto.core.repository

import kotlinx.coroutines.flow.first
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

    suspend fun setSourceLanguage(language: Language) {
        if (language == userData.first().targetLanguage) {
            Language.entries.firstOrNull { it != language && (it == Language.JAPANESE || it == Language.ENGLISH) }?.also {
                userDataStore.setTargetLanguage(it)
            }
        }

        userDataStore.setSourceLanguage(language)
    }

    suspend fun setTargetLanguage(language: Language) {
        if (language == userData.first().sourceLanguage) {
            Language.entries.firstOrNull { it != language && (it == Language.JAPANESE || it == Language.ENGLISH) }?.also {
                userDataStore.setSourceLanguage(it)
            }
        }

        if (language != Language.AUTO) {
            userDataStore.setTargetLanguage(language)
        }
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
