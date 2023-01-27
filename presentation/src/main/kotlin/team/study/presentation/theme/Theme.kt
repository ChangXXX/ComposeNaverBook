package team.study.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = Purple200,
    onPrimary = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColorScheme(
    primary = Purple500,
    onPrimary = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun Theme(
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}