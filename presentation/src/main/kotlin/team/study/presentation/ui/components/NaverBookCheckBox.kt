package team.study.presentation.ui.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun NaverMovieCheckBox(
    checked: Boolean,
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean,
) {
    Checkbox(
        checked = checked,
        onCheckedChange = { onClick() },
        colors = CheckboxDefaults.colors(
            checkedColor = MaterialTheme.colorScheme.tertiary,
            uncheckedColor = MaterialTheme.colorScheme.tertiaryContainer,
        ),
        modifier = modifier,
        enabled = enabled,
    )
}
