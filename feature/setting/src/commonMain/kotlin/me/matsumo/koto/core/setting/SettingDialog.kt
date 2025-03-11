package me.matsumo.koto.core.setting

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.DialogWindow
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.setting_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun SettingDialog(
    onCloseRequest: () -> Unit
) {
    DialogWindow(
        title = stringResource(Res.string.setting_title),
        resizable = false,
        onCloseRequest = onCloseRequest,
    ) {
        Text("Setting")
    }
}
