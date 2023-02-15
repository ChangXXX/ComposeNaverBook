package team.study.presentation.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ThemeScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ThemeCard("Dark Mode", {})
        ThemeCard("Light Mode", {})
        ThemeCard("Follow System", {})
    }
}

@Composable
private fun ThemeCard(
    title: String,
    onClickTheme: () -> Unit,
) {
    OutlinedCard(
        modifier = Modifier
            .padding(12.dp)
            .height(70.dp)
            .fillMaxWidth(),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
        ),
        border = CardDefaults.outlinedCardBorder(true),
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
            )
            Spacer(modifier = Modifier.weight(1f))
            Checkbox(
                checked = true,
                onCheckedChange = {},
                modifier = Modifier
                    .fillMaxHeight(),
            )
        }
    }
}
