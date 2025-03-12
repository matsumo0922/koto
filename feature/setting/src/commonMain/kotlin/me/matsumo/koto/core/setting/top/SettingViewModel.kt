package me.matsumo.koto.core.setting.top

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import me.matsumo.koto.core.domain.ScreenState
import me.matsumo.koto.core.domain.UserData
import me.matsumo.koto.core.repository.UserDataRepository

class SettingViewModel(
    private val userDataRepository: UserDataRepository,
) : ViewModel() {

    val screenState = userDataRepository.userData.map {
        ScreenState.Idle(
            SettingUiState(
                userData = it,
            ),
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = ScreenState.Loading,
    )

    fun setStartup(isStartup: Boolean) {
        viewModelScope.launch {
            userDataRepository.setStartup(isStartup)
        }
    }

    fun setShowRetranslation(isShowRetranslation: Boolean) {
        viewModelScope.launch {
            userDataRepository.setShowRetranslation(isShowRetranslation)
        }
    }

    fun setGoogleTranslateApiKey(apiKey: String) {
        viewModelScope.launch {
            userDataRepository.setGoogleTranslateApiKey(apiKey)
        }
    }

    fun setDeeplApiKey(apiKey: String) {
        viewModelScope.launch {
            userDataRepository.setDeeplApiKey(apiKey)
        }
    }

    fun setChatGptApiKey(apiKey: String) {
        viewModelScope.launch {
            userDataRepository.setChatGptApiKey(apiKey)
        }
    }
}

@Stable
data class SettingUiState(
    val userData: UserData,
)
