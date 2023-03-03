package team.study.presentation.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import team.study.presentation.ui.components.NaverBookSearchBar

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NaverBookSearchBar(
            modifier = Modifier,
            value = "",
            onValueChanged = {},
        )
    }
}
