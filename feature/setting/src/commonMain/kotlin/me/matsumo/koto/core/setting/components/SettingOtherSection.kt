package me.matsumo.koto.core.setting.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.setting_other_open_source_license
import me.matsumo.koto.core.resources.setting_other_privacy_policy
import me.matsumo.koto.core.resources.setting_other_terms_of_service
import me.matsumo.koto.core.resources.setting_other_title
import me.matsumo.koto.core.setting.SettingTextItem
import me.matsumo.koto.core.setting.SettingTopTitleItem

@Composable
internal fun SettingOtherSection(
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        SettingTopTitleItem(
            modifier = Modifier.fillMaxWidth(),
            text = Res.string.setting_other_title,
        )

        SettingTextItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.setting_other_terms_of_service,
        )

        SettingTextItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.setting_other_privacy_policy,
        )

        SettingTextItem(
            modifier = Modifier.fillMaxWidth(),
            title = Res.string.setting_other_open_source_license,
        )
    }
}
