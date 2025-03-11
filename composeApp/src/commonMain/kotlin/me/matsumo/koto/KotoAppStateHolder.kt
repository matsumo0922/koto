package me.matsumo.koto

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.matsumo.koto.core.repository.UserDataRepository

class KotoAppStateHolder(
    private val userDataRepository: UserDataRepository,
) {
    private val _dialogState = MutableStateFlow<DialogState>(DialogState.None)

    val dialogState = _dialogState.asStateFlow()
    val userData = userDataRepository.userData

    fun translationForward() {
        // TODO: Implement
    }

    fun translationBackward() {
        // TODO: Implement
    }

    fun setDialogState(dialogState: DialogState) {
        _dialogState.value = dialogState
    }

    sealed interface DialogState {
        data object None : DialogState
        data object Setting : DialogState
        data object History : DialogState
    }
}
