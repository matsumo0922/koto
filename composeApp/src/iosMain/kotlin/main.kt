import androidx.compose.ui.window.ComposeUIViewController
import me.matsumo.koto.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
