package me.matsumo.koto.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import me.matsumo.koto.core.domain.ThemeColorConfig
import me.matsumo.koto.core.domain.ThemeConfig
import me.matsumo.koto.core.ui.theme.color.DarkBlueColorScheme
import me.matsumo.koto.core.ui.theme.color.DarkBrownColorScheme
import me.matsumo.koto.core.ui.theme.color.DarkGreenColorScheme
import me.matsumo.koto.core.ui.theme.color.DarkPinkColorScheme
import me.matsumo.koto.core.ui.theme.color.DarkPurpleColorScheme
import me.matsumo.koto.core.ui.theme.color.LightBlueColorScheme
import me.matsumo.koto.core.ui.theme.color.LightBrownColorScheme
import me.matsumo.koto.core.ui.theme.color.LightGreenColorScheme
import me.matsumo.koto.core.ui.theme.color.LightPinckColorScheme
import me.matsumo.koto.core.ui.theme.color.LightPurpleColorScheme

val LightDefaultColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = Color.White,
    primaryContainer = Purple90,
    onPrimaryContainer = Purple10,
    secondary = Orange40,
    onSecondary = Color.White,
    secondaryContainer = Orange90,
    onSecondaryContainer = Orange10,
    tertiary = Blue40,
    onTertiary = Color.White,
    tertiaryContainer = Blue90,
    onTertiaryContainer = Blue10,
    error = Red40,
    onError = Color.White,
    errorContainer = Red90,
    onErrorContainer = Red10,
    background = DarkPurpleGray99,
    onBackground = DarkPurpleGray10,
    surface = DarkPurpleGray99,
    onSurface = DarkPurpleGray10,
    surfaceVariant = PurpleGray90,
    onSurfaceVariant = PurpleGray30,
    inverseSurface = DarkPurpleGray20,
    inverseOnSurface = DarkPurpleGray95,
    outline = PurpleGray50,
)

val DarkDefaultColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = Purple20,
    primaryContainer = Purple30,
    onPrimaryContainer = Purple90,
    secondary = Orange80,
    onSecondary = Orange20,
    secondaryContainer = Orange30,
    onSecondaryContainer = Orange90,
    tertiary = Blue80,
    onTertiary = Blue20,
    tertiaryContainer = Blue30,
    onTertiaryContainer = Blue90,
    error = Red80,
    onError = Red20,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = DarkPurpleGray10,
    onBackground = DarkPurpleGray90,
    surface = DarkPurpleGray10,
    onSurface = DarkPurpleGray90,
    surfaceVariant = PurpleGray30,
    onSurfaceVariant = PurpleGray80,
    inverseSurface = DarkPurpleGray90,
    inverseOnSurface = DarkPurpleGray10,
    outline = PurpleGray60,
)

val LocalColorScheme = staticCompositionLocalOf { LightDefaultColorScheme }

@Composable
fun KotoTheme(
    themeConfig: ThemeConfig = ThemeConfig.System,
    themeColorConfig: ThemeColorConfig = ThemeColorConfig.Blue,
    content: @Composable () -> Unit
) {
    val shouldUseDarkTheme = shouldUseDarkTheme(themeConfig)
    val colorScheme = getColorTheme(themeColorConfig, shouldUseDarkTheme)

    CompositionLocalProvider(
        LocalColorScheme provides colorScheme,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = KotoTypography,
            content = content
        )
    }
}

@Composable
private fun shouldUseDarkTheme(themeConfig: ThemeConfig): Boolean {
    return when (themeConfig) {
        ThemeConfig.System -> isSystemInDarkTheme()
        ThemeConfig.Light -> false
        ThemeConfig.Dark -> true
    }
}

private fun getColorTheme(themeColorConfig: ThemeColorConfig, shouldUseDarkTheme: Boolean) = when (themeColorConfig) {
    ThemeColorConfig.Blue -> if (shouldUseDarkTheme) DarkBlueColorScheme else LightBlueColorScheme
    ThemeColorConfig.Brown -> if (shouldUseDarkTheme) DarkBrownColorScheme else LightBrownColorScheme
    ThemeColorConfig.Green -> if (shouldUseDarkTheme) DarkGreenColorScheme else LightGreenColorScheme
    ThemeColorConfig.Purple -> if (shouldUseDarkTheme) DarkPurpleColorScheme else LightPurpleColorScheme
    ThemeColorConfig.Pink -> if (shouldUseDarkTheme) DarkPinkColorScheme else LightPinckColorScheme
    else -> if (shouldUseDarkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
}
