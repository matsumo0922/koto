package me.matsumo.koto.core.setting.language

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.rememberWindowState
import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.resources.Res
import me.matsumo.koto.core.resources.select_language_search_placeholder
import me.matsumo.koto.core.resources.select_language_title
import me.matsumo.koto.core.ui.theme.bold
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.jewel.window.DecoratedWindow
import org.jetbrains.jewel.window.TitleBar

@Suppress("ModifierMissing")
@Composable
fun SelectLanguageDialog(
    onCloseRequest: (Language?) -> Unit,
) {
    DecoratedWindow(
        title = stringResource(Res.string.select_language_title),
        state = rememberWindowState(size = DpSize(400.dp, 600.dp)),
        resizable = false,
        onCloseRequest = { onCloseRequest.invoke(null) },
    ) {
        TitleBar {
            Text(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .align(Alignment.Start),
                text = stringResource(Res.string.select_language_title),
                style = MaterialTheme.typography.titleSmall.bold(),
            )
        }

        var searchQuery by remember { mutableStateOf("") }
        val languageItems = remember { mutableStateListOf<LanguageSearchItem>() }
        val originalLanguagesItems = Language.entries.map {
            LanguageSearchItem(
                name = it.name,
                displayName = stringResource(it.displayName),
                language = it,
            )
        }

        LaunchedEffect(searchQuery) {
            languageItems.clear()
            languageItems.addAll(
                originalLanguagesItems.filter {
                    val isMatchedName = it.name.contains(searchQuery, ignoreCase = true)
                    val isMatchedDisplayName = it.displayName.contains(searchQuery, ignoreCase = true)

                    isMatchedName || isMatchedDisplayName
                }
            )
        }

        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text(stringResource(Res.string.select_language_search_placeholder)) },
                singleLine = true,
            )

            LazyVerticalGrid(
                modifier = Modifier.weight(1f),
                columns = GridCells.Fixed(3),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                items(
                    items = languageItems,
                    key = { it.name },
                ) {
                    Text(
                        modifier = Modifier
                            .animateItem()
                            .clickable { onCloseRequest.invoke(it.language) }
                            .padding(8.dp),
                        text = it.displayName,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}

@Stable
private data class LanguageSearchItem(
    val name: String,
    val displayName: String,
    val language: Language,
)
