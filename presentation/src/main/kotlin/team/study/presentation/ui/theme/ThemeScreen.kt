package team.study.presentation.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import team.study.presentation.ui.components.NaverBookProgressAnimated
import team.study.presentation.ui.components.NaverMovieCheckBox

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun ThemeScreen(
    themeViewModel: ThemeViewModel = hiltViewModel(),
) {
    val themeUiState by themeViewModel.themeUiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ThemeRadioCards(
            themeUiState = themeUiState,
            onUpdateTheme = themeViewModel::updateTheme,
        )
    }
}

@Composable
fun ThemeRadioCards(
    themeUiState: ThemeUiState,
    onUpdateTheme: (title: String) -> Unit,
) {
    when (themeUiState) {
        is ThemeUiState.Loading -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            ) {
                NaverBookProgressAnimated()
            }
        }
        is ThemeUiState.Success -> {
            val groups = listOf(Themes.System.name, Themes.Light.name, Themes.Dark.name)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .selectableGroup(),
            ) {
                groups.forEach { title ->
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .height(70.dp)
                            .fillMaxWidth(),
                    ) {
                        ThemeCard(
                            title = title,
                            onUpdateTheme = { onUpdateTheme(title) },
                            selected = title == themeUiState.themes.name,
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ThemeCard(
    title: String,
    onUpdateTheme: () -> Unit,
    selected: Boolean,
) {
    OutlinedCard(
        modifier = Modifier.fillMaxSize(),
        colors = CardDefaults.outlinedCardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.outline),
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
                color = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.padding(start = 12.dp),
            )
            Spacer(modifier = Modifier.weight(1f))
            NaverMovieCheckBox(
                checked = selected,
                onClick = onUpdateTheme,
                modifier = Modifier
                    .fillMaxHeight(),
                enabled = true,
            )
        }
    }
}
