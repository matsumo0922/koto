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
    swapLanguage: () -> Unit,
    selectSourceLanguage: () -> Unit,
    selectTargetLanguage: () -> Unit,
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
            sourceLanguage = uiState.userData.sourceLanguage,
            targetLanguage = uiState.userData.targetLanguage,
            onSwapLanguage = swapLanguage,
            onSelectSourceLanguage = selectSourceLanguage,
            onSelectTargetLanguage = selectTargetLanguage,
        )

        HomeEditor(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            uiState = uiState,
            onTranslationRequested = viewModel::translation,
        )

        HomeServiceSelector(
            modifier = Modifier.wrapContentWidth(),
            selectedTranslationService = uiState.userData.selectedTranslationService,
            onTranslationServiceChanged = viewModel::selectTranslationService,
        )
    }
}
