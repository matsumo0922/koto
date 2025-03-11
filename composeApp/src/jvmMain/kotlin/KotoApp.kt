import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.application
import me.matsumo.koto.KotoApp
import me.matsumo.koto.KotoAppStateHolder
import me.matsumo.koto.core.domain.UserData
import me.matsumo.koto.core.ui.theme.shouldUseDarkTheme
import me.matsumo.koto.di.initKoin
import me.matsumo.koto.ui.KotoTitleBar
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.foundation.theme.ThemeDefinition
import org.jetbrains.jewel.intui.standalone.theme.IntUiTheme
import org.jetbrains.jewel.intui.standalone.theme.darkThemeDefinition
import org.jetbrains.jewel.intui.standalone.theme.default
import org.jetbrains.jewel.intui.standalone.theme.lightThemeDefinition
import org.jetbrains.jewel.intui.window.decoratedWindow
import org.jetbrains.jewel.intui.window.styling.dark
import org.jetbrains.jewel.intui.window.styling.lightWithLightHeader
import org.jetbrains.jewel.ui.ComponentStyling
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.styling.TitleBarStyle
import org.koin.compose.koinInject

fun main() {
    initKoin()
    application {
        val appState = koinInject<KotoAppStateHolder>()
        val userData by appState.userData.collectAsState(UserData.default())

        val theme: ThemeDefinition
        val titleBarStyle: TitleBarStyle

        if (shouldUseDarkTheme(userData.themeConfig)) {
            theme = JewelTheme.darkThemeDefinition()
            titleBarStyle = TitleBarStyle.dark()
        } else {
            theme = JewelTheme.lightThemeDefinition()
            titleBarStyle = TitleBarStyle.lightWithLightHeader()
        }

        IntUiTheme(
            theme = theme,
            styling = ComponentStyling.default().decoratedWindow(titleBarStyle = titleBarStyle),
            swingCompatMode = true,
        ) {
            DecoratedWindow(
                title = "koto",
                onCloseRequest = ::exitApplication,
            ) {
                KotoTitleBar(
                    modifier = Modifier.fillMaxWidth(),
                    onForwardClicked = appState::translationForward,
                    onBackwardClicked = appState::translationBackward,
                    onHistoryClicked = { appState.setDialogState(KotoAppStateHolder.DialogState.History) },
                    onSettingClicked = { appState.setDialogState(KotoAppStateHolder.DialogState.Setting) },
                )

                KotoApp(
                    appState = appState,
                )
            }
        }
    }
}
