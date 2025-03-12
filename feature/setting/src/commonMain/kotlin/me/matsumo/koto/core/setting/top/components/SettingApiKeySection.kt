package me.matsumo.koto.core.setting.top.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.matsumo.koto.core.domain.UserData
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.setting_api_key_placeholder
import me.matsumo.koto.core.resources.setting_api_title
import me.matsumo.koto.core.resources.translation_service_chatgpt
import me.matsumo.koto.core.resources.translation_service_deepl
import me.matsumo.koto.core.resources.translation_service_google
import me.matsumo.koto.core.setting.top.SettingEditItem
import me.matsumo.koto.core.setting.top.SettingTopTitleItem

@Composable
internal fun SettingApiKeySection(
    userData: UserData,
    onGoogleApiKeyChanged: (String) -> Unit,
    onDeeplApiKeyChanged: (String) -> Unit,
    onChatGptApiKeyChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        SettingTopTitleItem(
            modifier = Modifier.fillMaxWidth(),
            text = Res.string.setting_api_title,
        )

        SettingEditItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.translation_service_google,
            description = Res.string.translation_service_google,
            placeholder = Res.string.setting_api_key_placeholder,
            value = userData.googleTranslateApiKey,
            onValueChanged = onGoogleApiKeyChanged,
            maxLines = 1,
        )

        SettingEditItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.translation_service_deepl,
            description = Res.string.translation_service_deepl,
            placeholder = Res.string.setting_api_key_placeholder,
            value = userData.deeplApiKey,
            onValueChanged = onDeeplApiKeyChanged,
            maxLines = 1,
        )

        SettingEditItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.translation_service_chatgpt,
            description = Res.string.translation_service_chatgpt,
            placeholder = Res.string.setting_api_key_placeholder,
            value = userData.chatGptApiKey,
            onValueChanged = onChatGptApiKeyChanged,
            maxLines = 1,
        )
    }
}
