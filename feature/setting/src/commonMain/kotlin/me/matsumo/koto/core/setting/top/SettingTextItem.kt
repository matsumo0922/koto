package me.matsumo.koto.core.setting.top

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingTextItem(
    title: String,
    modifier: Modifier = Modifier,
    description: String? = null,
    onClick: () -> Unit = {},
    onLongClick: () -> Unit = {},
    enable: Boolean = true,
    icon: ImageVector? = null,
) {
    val titleColor: Color
    val descriptionColor: Color

    if (enable) {
        titleColor = MaterialTheme.colorScheme.onSurface
        descriptionColor = MaterialTheme.colorScheme.onSurfaceVariant
    } else {
        MaterialTheme.colorScheme.onSurface
            .copy(alpha = 0.38f)
            .compositeOver(MaterialTheme.colorScheme.surface)
            .also {
                titleColor = it
                descriptionColor = it
            }
    }

    Row(
        modifier = modifier
            .combinedClickable(
                enabled = enable,
                onClick = { onClick.invoke() },
                onLongClick = { onLongClick.invoke() },
            )
            .padding(horizontal = 24.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        if (icon != null) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = icon,
                contentDescription = null,
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = titleColor,
        )

        Spacer(
            modifier = Modifier.weight(1f),
        )

        if (description != null) {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = descriptionColor,
            )
        }
    }
}

@Composable
fun SettingTextItem(
    title: StringResource,
    modifier: Modifier = Modifier,
    description: StringResource? = null,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    icon: ImageVector? = null,
) {
    SettingTextItem(
        modifier = modifier,
        title = stringResource(title),
        description = description?.let { stringResource(it) },
        onClick = onClick,
        enable = enabled,
        icon = icon,
    )
}
