package me.matsumo.koto

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.matsumo.koto.core.domain.ThemeConfig
import me.matsumo.koto.core.ui.theme.KotoTheme
import me.matsumo.koto.feature.home.HomeScreen

@Composable
internal fun KotoApp() {
    KotoTheme {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
