package me.matsumo.koto.core.setting

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingEditItem(
    title: String,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    description: String? = null,
    placeholder: String? = null,
    maxLines: Int = Int.MAX_VALUE,
    enable: Boolean = true,
    icon: ImageVector? = null,
) {
    var localValue by remember(value) { mutableStateOf(value) }

    val titleColor: Color
    val descriptionColor: Color

    LaunchedEffect(localValue) {
        delay(1000)
        onValueChanged.invoke(localValue)
    }

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

    Column(
        modifier = modifier.padding(horizontal = 24.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
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

        BasicTextField(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp))
                .padding(8.dp),
            value = localValue,
            onValueChange = { localValue = it },
            textStyle = MaterialTheme.typography.bodyMedium.copy(
                color = MaterialTheme.colorScheme.onSurface,
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                hintLocales = LocaleList(Locale("en"))
            ),
            maxLines = maxLines,
            decorationBox = { innerTextField ->
                if (localValue.isEmpty() && placeholder != null) {
                    Text(
                        text = placeholder,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }

                innerTextField()
            }
        )
    }
}

@Composable
fun SettingEditItem(
    title: StringResource,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
    description: StringResource? = null,
    placeholder: StringResource? = null,
    maxLines: Int = Int.MAX_VALUE,
    enabled: Boolean = true,
    icon: ImageVector? = null,
) {
    SettingEditItem(
        modifier = modifier,
        title = stringResource(title),
        description = description?.let { stringResource(it) },
        placeholder = placeholder?.let { stringResource(it) },
        value = value,
        onValueChanged = onValueChanged,
        maxLines = maxLines,
        enable = enabled,
        icon = icon,
    )
}
