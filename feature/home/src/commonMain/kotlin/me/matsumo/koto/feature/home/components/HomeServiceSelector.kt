package me.matsumo.koto.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import me.matsumo.koto.core.domain.TranslationService
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun HomeServiceSelector(
    selectedTranslationService: TranslationService,
    onTranslationServiceChanged: (TranslationService) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TranslationService.entries.forEach {
            ServiceItem(
                translationService = it,
                selected = it == selectedTranslationService,
                onClick = onTranslationServiceChanged,
            )
        }
    }
}

@Composable
private fun ServiceItem(
    selected: Boolean,
    translationService: TranslationService,
    onClick: (TranslationService) -> Unit,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (selected) {
        MaterialTheme.colorScheme.primaryContainer
    } else {
        MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp)
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable { onClick.invoke(translationService) }
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AsyncImage(
            modifier = Modifier.size(20.dp),
            model = translationService.iconUrl,
            contentDescription = null,
        )

        Text(
            text = stringResource(translationService.displayName),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}
