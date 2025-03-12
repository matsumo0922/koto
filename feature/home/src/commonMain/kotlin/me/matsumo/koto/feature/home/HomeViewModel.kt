package me.matsumo.koto.feature.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.matsumo.koto.core.common.suspendRunCatching
import me.matsumo.koto.core.domain.Translation
import me.matsumo.koto.core.domain.TranslationService
import me.matsumo.koto.core.domain.UserData
import me.matsumo.koto.core.repository.TranslationRepository
import me.matsumo.koto.core.repository.UserDataRepository
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class HomeViewModel(
    private val userDataRepository: UserDataRepository,
    private val translationRepository: TranslationRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            userDataRepository.userData.collect {
                if (it.kotoId.isEmpty()) {
                    userDataRepository.setKotoId(Uuid.random().toHexString())
                }

                _uiState.value = _uiState.value.copy(userData = it)
            }
        }
    }

    fun translation(text: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                loading = true,
                error = null,
            )

            val targetLanguage = uiState.value.userData.targetLanguage
            val sourceLanguage = uiState.value.userData.sourceLanguage
            val service = uiState.value.userData.selectedTranslationService

            suspendRunCatching {
                translationRepository.translate(
                    text = text,
                    sourceLanguage = sourceLanguage,
                    targetLanguage = targetLanguage,
                    service = service,
                )
            }.onSuccess {
                _uiState.value = _uiState.value.copy(
                    translation = it,
                    loading = false,
                )
            }.onFailure {
                _uiState.value = _uiState.value.copy(
                    error = it.message,
                    loading = false,
                )
            }
        }
    }

    fun selectTranslationService(translationService: TranslationService) {
        viewModelScope.launch {
            userDataRepository.setSelectedTranslationService(translationService)
        }
    }
}

@Stable
data class HomeUiState(
    val userData: UserData = UserData.default(),
    val translation: Translation? = null,
    val loading: Boolean = false,
    val error: String? = null
)
