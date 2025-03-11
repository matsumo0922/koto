package me.matsumo.koto.core.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val kotoId: String,
    val themeConfig: ThemeConfig,
    val themeColorConfig: ThemeColorConfig,
    val googleTranslateApiKey: String,
    val deeplApiKey: String,
    val chatGptApiKey: String,
) {
    companion object {
        fun default(): UserData {
            return UserData(
                kotoId = "",
                themeConfig = ThemeConfig.System,
                themeColorConfig = ThemeColorConfig.Blue,
                googleTranslateApiKey = "",
                deeplApiKey = "",
                chatGptApiKey = "",
            )
        }
    }
}
