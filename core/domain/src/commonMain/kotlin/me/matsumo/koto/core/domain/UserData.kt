package me.matsumo.koto.core.domain

import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    val kotoId: String,
    val themeConfig: ThemeConfig,
    val themeColorConfig: ThemeColorConfig,
    val isAgreedPrivacyPolicy: Boolean,
    val isAgreedTermsOfService: Boolean,
    val isDeveloperMode: Boolean,
    val isPlusMode: Boolean,
) {
    val hasPrivilege get() = isPlusMode || isDeveloperMode

    companion object {
        fun default(): UserData {
            return UserData(
                kotoId = "",
                themeConfig = ThemeConfig.System,
                themeColorConfig = ThemeColorConfig.Blue,
                isAgreedPrivacyPolicy = false,
                isAgreedTermsOfService = false,
                isDeveloperMode = false,
                isPlusMode = false,
            )
        }
    }
}
