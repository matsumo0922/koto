package me.matsumo.koto.core.setting

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.rememberWindowState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.setting_title
import me.matsumo.koto.core.setting.components.SettingApiKeySection
import me.matsumo.koto.core.setting.components.SettingGeneralSection
import me.matsumo.koto.core.setting.components.SettingOtherSection
import me.matsumo.koto.core.ui.AsyncLoadContents
import me.matsumo.koto.core.ui.theme.bold
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.TitleBar
import org.koin.compose.viewmodel.koinViewModel

@Suppress("ModifierMissing")
@Composable
fun SettingDialog(
    onCloseRequest: () -> Unit,
    viewModel: SettingViewModel = koinViewModel(),
) {
    DecoratedWindow(
        title = stringResource(Res.string.setting_title),
        state = rememberWindowState(size = DpSize(600.dp, 800.dp)),
        resizable = false,
        onCloseRequest = onCloseRequest,
    ) {
        TitleBar {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.Start),
                text = stringResource(Res.string.setting_title),
                style = MaterialTheme.typography.titleSmall.bold(),
            )
        }

        val screenState by viewModel.screenState.collectAsStateWithLifecycle()

        AsyncLoadContents(
            modifier = Modifier.fillMaxSize(),
            screenState = screenState,
            containerColor = MaterialTheme.colorScheme.background,
            terminate = onCloseRequest,
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                item {
                    SettingGeneralSection(
                        modifier = Modifier.fillMaxWidth(),
                        isStartup = it.userData.isStartup,
                        isShowRetranslation = it.userData.isShowRetranslation,
                        onStartupChanged = viewModel::setStartup,
                        onShowRetranslationChanged = viewModel::setShowRetranslation,
                    )
                }

                item {
                    SettingApiKeySection(
                        modifier = Modifier.fillMaxWidth(),
                        userData = it.userData,
                        onGoogleApiKeyChanged = viewModel::setGoogleTranslateApiKey,
                        onDeeplApiKeyChanged = viewModel::setDeeplApiKey,
                        onChatGptApiKeyChanged = viewModel::setChatGptApiKey,
                    )
                }

                item {
                    SettingOtherSection(
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }
        }
    }
}
