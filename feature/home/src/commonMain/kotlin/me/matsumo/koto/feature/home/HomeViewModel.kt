package me.matsumo.koto.feature.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.domain.TranslationService
import me.matsumo.koto.core.domain.UserData
import me.matsumo.koto.core.repository.UserDataRepository
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalUuidApi::class)
class HomeViewModel(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(userData = UserData.default()))
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

    fun selectTargetLanguage(language: Language) {
        viewModelScope.launch {
            userDataRepository.setTargetLanguage(language)
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
    val userData: UserData,
)
