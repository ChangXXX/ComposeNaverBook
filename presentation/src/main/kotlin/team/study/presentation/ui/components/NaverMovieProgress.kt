package team.study.presentation.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

@Composable
fun NaverMovieProgressAnimated() {
    val transition = rememberInfiniteTransition()
    val progressAnimationValue by transition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(animation = tween(900), RepeatMode.Restart),
    )
    CircularProgressIndicator(
        progress = progressAnimationValue,
        color = MaterialTheme.colorScheme.primaryContainer,
    )
}
