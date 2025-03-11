package me.matsumo.koto.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.matsumo.koto.core.ui.theme.DarkDefaultColorScheme
import me.matsumo.koto.core.ui.theme.LightDefaultColorScheme
import org.jetbrains.jewel.ui.component.Icon
import org.jetbrains.jewel.ui.component.IconButton
import org.jetbrains.jewel.window.DecoratedWindowScope
import org.jetbrains.jewel.window.TitleBar

@Composable
internal fun DecoratedWindowScope.KotoTitleBar(
    modifier: Modifier = Modifier,
) {
    TitleBar(
        modifier = modifier,
        content = {
            NavigationControl(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.Start),
            )

            SettingControl(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.End),
            )
        }
    )
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun NavigationControl(
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier,

        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = { }
        ) {
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                tint = tintColor,
                contentDescription = "Back",
            )
        }

        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = { }
        ) {
            Icon(
                modifier = Modifier.padding(4.dp),
                imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                tint = tintColor,
                contentDescription = "Forward",
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun SettingControl(
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = { }
        ) {
            Icon(
                modifier = Modifier.padding(2.dp),
                imageVector = Icons.Default.History,
                tint = tintColor,
                contentDescription = "History",
            )
        }

        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = { }
        ) {
            Icon(
                modifier = Modifier.padding(2.dp),
                imageVector = Icons.Default.Settings,
                tint = tintColor,
                contentDescription = "Setting",
            )
        }
    }
}

private val tintColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) {
        DarkDefaultColorScheme.onSurfaceVariant
    } else {
        LightDefaultColorScheme.onSurfaceVariant
    }
