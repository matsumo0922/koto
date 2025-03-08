import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import me.matsumo.koto.KotoApp
import java.awt.Dimension

fun main() = application {
    Window(
        title = "koto",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)
        KotoApp()
    }
}

@Preview
@Composable
fun AppPreview() { KotoApp() }
