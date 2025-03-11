package me.matsumo.koto.core.setting.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.setting_api_title
import me.matsumo.koto.core.resources.setting_general
import me.matsumo.koto.core.resources.setting_general_language
import me.matsumo.koto.core.resources.setting_general_retranslation
import me.matsumo.koto.core.resources.setting_general_startup
import me.matsumo.koto.core.setting.SettingSwitchItem
import me.matsumo.koto.core.setting.SettingTextItem
import me.matsumo.koto.core.setting.SettingTopTitleItem
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun SettingGeneralSection(
    isStartup: Boolean,
    isShowRetranslation: Boolean,
    onStartupChanged: (Boolean) -> Unit,
    onShowRetranslationChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        SettingTopTitleItem(
            modifier = Modifier.fillMaxWidth(),
            text = Res.string.setting_general,
        )

        SettingTextItem(
            modifier = Modifier.fillMaxWidth(),
            title = stringResource(Res.string.setting_general_language),
            description = "日本語"
        )

        SettingSwitchItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.setting_general_startup,
            value = isStartup,
            onValueChanged = onStartupChanged,
        )

        SettingSwitchItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.setting_general_retranslation,
            value = isShowRetranslation,
            onValueChanged = onShowRetranslationChanged,
        )
    }
}
