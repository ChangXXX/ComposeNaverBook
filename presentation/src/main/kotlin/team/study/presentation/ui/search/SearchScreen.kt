package team.study.presentation.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import team.study.presentation.ui.components.NaverBookSearchBar

@Composable
fun SearchScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var searchValue by remember { mutableStateOf("") }
        val view = LocalFocusManager.current

        NaverBookSearchBar(
            modifier = Modifier,
            value = searchValue,
            onClear = {
                searchValue = ""
                view.clearFocus()
            },
            onDone = {
                view.clearFocus()
            },
            onFocusChanged = { focusState ->
                focusState.isFocused
            },
            onValueChanged = { query ->
                searchValue = query
            },
        )
    }
}
