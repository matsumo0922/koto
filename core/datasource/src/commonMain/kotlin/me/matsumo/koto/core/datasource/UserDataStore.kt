package me.matsumo.koto.core.datasource

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import me.matsumo.koto.core.domain.ThemeColorConfig
import me.matsumo.koto.core.domain.ThemeConfig

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
}
