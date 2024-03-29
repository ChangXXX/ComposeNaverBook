package team.study.presentation.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NaverBookProgressAnimated() {
    val transition = rememberInfiniteTransition()
    val progressAnimationValue by transition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(animation = tween(900), RepeatMode.Restart),
    )
    CircularProgressIndicator(
        modifier = Modifier.size(32.dp),
        progress = progressAnimationValue,
        color = MaterialTheme.colorScheme.primary,
    )
}
