@file:Suppress("ModifierReused")

package me.matsumo.koto.core.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.matsumo.koto.core.domain.ScreenState
import me.matsumo.koto.core.ui.view.ErrorView
import me.matsumo.koto.core.ui.view.LoadingView

@Composable
fun <T> AsyncLoadContents(
    screenState: ScreenState<T>,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    cornerShape: RoundedCornerShape = RoundedCornerShape(0.dp),
    retryAction: (() -> Unit)? = null,
    terminate: (() -> Unit)? = null,
    content: @Composable (T) -> Unit,
) {
    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
    ) {
        AnimatedContent(
            modifier = Modifier
                .clip(cornerShape)
                .background(containerColor),
            targetState = screenState,
            transitionSpec = { fadeIn().togetherWith(fadeOut()) },
            contentKey = { it::class.simpleName },
            label = "AsyncLoadContents",
        ) { state ->
            when (state) {
                is ScreenState.Idle -> {
                    content.invoke(state.data)
                }

                is ScreenState.Loading -> {
                    LoadingView(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Black.copy(alpha = 0.2f)),
                    )
                }

                is ScreenState.Error -> {
                    ErrorView(
                        modifier = Modifier.fillMaxWidth(),
                        errorState = state,
                        retryAction = retryAction,
                        terminate = terminate,
                    )
                }
            }
        }
    }
}
