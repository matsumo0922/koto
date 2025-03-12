package me.matsumo.koto.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.intl.LocaleList
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.home_editor_placeholder
import me.matsumo.koto.core.ui.view.LoadingView
import me.matsumo.koto.feature.home.HomeUiState
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun HomeEditor(
    uiState: HomeUiState,
    onTranslationRequested: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val state = rememberTextFieldState()

    LaunchedEffect(state.text) {
        if (state.text.isNotBlank()) {
            delay(1000)
            onTranslationRequested.invoke(state.text.toString())
        }
    }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        EditorItem(
            modifier = Modifier.weight(1f),
            state = state,
        )

        SelectionContainer(
            modifier = Modifier.weight(1f)
        ) {
            PreviewItem(
                modifier = Modifier.fillMaxWidth(),
                translatedText = uiState.translation?.translatedText.orEmpty(),
                reTranslatedText = uiState.translation?.reTranslatedText.orEmpty(),
                loading = uiState.loading,
                error = uiState.error,
            )
        }
    }
}

@Composable
private fun EditorItem(
    state: TextFieldState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        BasicTextField(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            state = state,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            textStyle = MaterialTheme.typography.bodyLarge.copy(
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp,
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Text,
            ),
            decorator = { innerTextField ->
                Box {
                    if (state.text.isEmpty()) {
                        Text(
                            text = stringResource(Res.string.home_editor_placeholder),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            fontSize = 24.sp,
                        )
                    }

                    innerTextField()
                }
            },
        )
    }
}

@Composable
private fun PreviewItem(
    translatedText: String,
    reTranslatedText: String,
    loading: Boolean,
    error: String?,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceColorAtElevation(2.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (!loading) {
            Text(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                text = error ?: translatedText,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 24.sp,
            )

            if (reTranslatedText.isNotEmpty() && error == null) {
                HorizontalDivider()

                Text(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    text = reTranslatedText,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            }
        } else {
            LoadingView(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
            )
        }
    }
}
