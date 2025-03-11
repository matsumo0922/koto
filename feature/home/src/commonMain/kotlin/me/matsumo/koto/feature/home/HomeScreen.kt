package me.matsumo.koto.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import me.matsumo.koto.feature.home.components.HomeEditor
import me.matsumo.koto.feature.home.components.HomeLanguageSelector
import me.matsumo.koto.feature.home.components.HomeServiceSelector
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HomeLanguageSelector(
            modifier = Modifier.wrapContentWidth(),
            targetLanguage = uiState.userData.targetLanguage,
        )

        HomeEditor(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        )

        HomeServiceSelector(
            modifier = Modifier.wrapContentWidth(),
            selectedTranslationService = uiState.userData.selectedTranslationService,
            onTranslationServiceChanged = viewModel::selectTranslationService,
        )
    }
}
