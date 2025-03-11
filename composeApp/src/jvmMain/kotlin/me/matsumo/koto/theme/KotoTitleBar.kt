package me.matsumo.koto.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.jewel.foundation.theme.JewelTheme
import org.jetbrains.jewel.intui.window.styling.lightWithLightHeader
import org.jetbrains.jewel.ui.theme.colorPalette
import org.jetbrains.jewel.window.DecoratedWindowScope
import org.jetbrains.jewel.window.TitleBar
import org.jetbrains.jewel.window.styling.TitleBarStyle

@Composable
internal fun DecoratedWindowScope.KotoTitleBar(
    modifier: Modifier = Modifier,
) {
    TitleBar(
        modifier = modifier,
        style = TitleBarStyle.lightWithLightHeader(),
        content = {

        }
    )
}
