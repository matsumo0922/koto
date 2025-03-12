package me.matsumo.koto

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.matsumo.koto.core.domain.UserData
import me.matsumo.koto.core.setting.language.SelectLanguageDialog
import me.matsumo.koto.core.setting.top.SettingDialog
import me.matsumo.koto.core.ui.theme.KotoTheme
import me.matsumo.koto.feature.home.HomeScreen

@Composable
internal fun KotoApp(
    appState: KotoAppStateHolder,
) {
    val userData by appState.userData.collectAsStateWithLifecycle(UserData.default())
    val dialogState by appState.dialogState.collectAsStateWithLifecycle()

    KotoTheme(
        themeConfig = userData.themeConfig,
        themeColorConfig = userData.themeColorConfig,
    ) {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            selectSourceLanguage = { appState.setDialogState(KotoAppStateHolder.DialogState.SelectLanguage(KotoAppStateHolder.LanguageType.SOURCE)) },
            selectTargetLanguage = { appState.setDialogState(KotoAppStateHolder.DialogState.SelectLanguage(KotoAppStateHolder.LanguageType.TARGET)) },
            swapLanguage = { appState.swapLanguage() },
        )

        when (val state = dialogState) {
            KotoAppStateHolder.DialogState.Setting -> {
                SettingDialog(
                    onCloseRequest = { appState.setDialogState(KotoAppStateHolder.DialogState.None) },
                )
            }

            KotoAppStateHolder.DialogState.History -> {
                // do nothing
            }

            is KotoAppStateHolder.DialogState.SelectLanguage -> {
                SelectLanguageDialog(
                    onCloseRequest = {
                        if (it != null) appState.setLanguage(state.type, it)
                        appState.setDialogState(KotoAppStateHolder.DialogState.None)
                    }
                )
            }

            else -> {
                // do nothing
            }
        }
    }
}
