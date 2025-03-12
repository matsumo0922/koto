package me.matsumo.koto.core.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val kotoId: String,
    val themeConfig: ThemeConfig,
    val themeColorConfig: ThemeColorConfig,
    val sourceLanguage: Language,
    val targetLanguage: Language,
    val selectedTranslationService: TranslationService,
    val googleTranslateApiKey: String,
    val deeplApiKey: String,
    val chatGptApiKey: String,
    val isStartup: Boolean,
    val isShowRetranslation: Boolean,
) {
    companion object {
        fun default(): UserData {
            return UserData(
                kotoId = "",
                themeConfig = ThemeConfig.System,
                themeColorConfig = ThemeColorConfig.Blue,
                sourceLanguage = Language.AUTO,
                targetLanguage = Language.JAPANESE,
                selectedTranslationService = TranslationService.Google,
                googleTranslateApiKey = "",
                deeplApiKey = "",
                chatGptApiKey = "",
                isStartup = false,
                isShowRetranslation = true,
            )
        }
    }
}
