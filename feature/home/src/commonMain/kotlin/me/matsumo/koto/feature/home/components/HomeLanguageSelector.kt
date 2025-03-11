package me.matsumo.koto.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import me.matsumo.koto.core.domain.Language
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun HomeLanguageSelector(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.CenterHorizontally,
        ),
    ) {
        LanguageSelector(
            modifier = Modifier.widthIn(min = 192.dp),
            language = Language.AUTO,
        )

        IconButton(
            onClick = { /* TODO */ },
        ) {
            Icon(
                imageVector = Icons.Default.SwapHoriz,
                tint = MaterialTheme.colorScheme.onSurface,
                contentDescription = null,
            )
        }

        LanguageSelector(
            modifier = Modifier.widthIn(min = 192.dp),
            language = Language.JAPANESE,
        )
    }
}

@Composable
private fun LanguageSelector(
    language: Language,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp))
            .clickable { }
            .padding(4.dp, 8.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = stringResource(language.displayName),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}
