package me.matsumo.koto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import me.matsumo.koto.core.domain.Language
import me.matsumo.koto.core.repository.UserDataRepository

class KotoAppStateHolder(
    private val userDataRepository: UserDataRepository,
)  {
    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private val _dialogState = MutableStateFlow<DialogState>(DialogState.None)

    val dialogState = _dialogState.asStateFlow()
    val userData = userDataRepository.userData

    fun translationForward() {
        // TODO: Implement
    }

    fun translationBackward() {
        // TODO: Implement
    }

    fun swapLanguage() {
        scope.launch {
            val userData = userDataRepository.userData.first()

            userDataRepository.setSourceLanguage(userData.targetLanguage)
            userDataRepository.setTargetLanguage(userData.sourceLanguage)
        }
    }

    fun setLanguage(type: LanguageType, language: Language) {
        scope.launch {
            when (type) {
                LanguageType.SOURCE -> userDataRepository.setSourceLanguage(language)
                LanguageType.TARGET -> userDataRepository.setTargetLanguage(language)
            }
        }
    }

    fun setDialogState(dialogState: DialogState) {
        _dialogState.value = dialogState
    }

    sealed interface DialogState {
        data object None : DialogState
        data object Setting : DialogState
        data object History : DialogState
        data class SelectLanguage(val type: LanguageType) : DialogState
    }

    enum class LanguageType {
        SOURCE,
        TARGET,
    }
}
