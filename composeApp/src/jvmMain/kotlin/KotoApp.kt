import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import me.matsumo.koto.KotoApp
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.foundation.theme.ThemeDefinition
import org.jetbrains.jewel.intui.standalone.theme.IntUiTheme
import org.jetbrains.jewel.intui.standalone.theme.default
import org.jetbrains.jewel.intui.standalone.theme.lightThemeDefinition
import org.jetbrains.jewel.intui.window.decoratedWindow
import org.jetbrains.jewel.intui.window.styling.light
import org.jetbrains.jewel.intui.window.styling.lightWithLightHeader
import org.jetbrains.jewel.ui.ComponentStyling
import org.jetbrains.jewel.ui.theme.colorPalette
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.DecoratedWindowScope
import org.jetbrains.jewel.window.TitleBar
import org.jetbrains.jewel.window.styling.TitleBarStyle
import java.awt.Dimension

fun main() = application {
    IntUiTheme(
        theme = JewelTheme.lightThemeDefinition(),
        styling = ComponentStyling.default().decoratedWindow(
            titleBarStyle = TitleBarStyle.lightWithLightHeader()
        ),
        swingCompatMode = true,
    ) {
        DecoratedWindow(
            title = "koto",
            state = rememberWindowState(width = 800.dp, height = 600.dp),
            onCloseRequest = ::exitApplication,
        ) {
            TitleBar(
                modifier = Modifier.fillMaxWidth(),
                style = TitleBarStyle.lightWithLightHeader(),
                gradientStartColor = JewelTheme.colorPalette.purple(8),
                content = {

                }
            )

            KotoApp()
        }
    }
}
