import androidx.compose.ui.window.ComposeUIViewController
import me.matsumo.koto.KotoApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { KotoApp() }
