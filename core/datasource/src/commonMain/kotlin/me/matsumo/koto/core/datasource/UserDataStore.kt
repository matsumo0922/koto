package me.matsumo.koto.core.datasource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.domain.ThemeColorConfig
import me.matsumo.koto.core.domain.ThemeConfig
import me.matsumo.koto.core.domain.TranslationService

class UserDataStore(
    private val ioDispatcher: CoroutineDispatcher,
) {
    private val userPreference = PreferenceHelper.create(
        name = PreferencesName.APP_SETTINGS,
        serializer = userDataSerializer,
    )

    val userData = userPreference.data

    suspend fun setKotoId(id: String) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(kotoId = id)
        }
    }

    suspend fun setThemeConfig(themeConfig: ThemeConfig) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(themeConfig = themeConfig)
        }
    }

    suspend fun setThemeColorConfig(themeColorConfig: ThemeColorConfig) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(themeColorConfig = themeColorConfig)
        }
    }

    suspend fun setSourceLanguage(language: Language) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(sourceLanguage = language)
        }
    }

    suspend fun setTargetLanguage(language: Language) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(targetLanguage = language)
        }
    }

    suspend fun setSelectedTranslationService(translationService: TranslationService) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(selectedTranslationService = translationService)
        }
    }

    suspend fun setGoogleTranslateApiKey(apiKey: String) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(googleTranslateApiKey = apiKey)
        }
    }

    suspend fun setDeeplApiKey(apiKey: String) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(deeplApiKey = apiKey)
        }
    }

    suspend fun setChatGptApiKey(apiKey: String) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(chatGptApiKey = apiKey)
        }
    }

    suspend fun setStartup(isStartup: Boolean) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(isStartup = isStartup)
        }
    }

    suspend fun setShowRetranslation(isShowRetranslation: Boolean) = withContext(ioDispatcher) {
        userPreference.updateData {
            it.copy(isShowRetranslation = isShowRetranslation)
        }
    }
}
