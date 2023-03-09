package team.study.presentation.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import team.study.presentation.extension.clearFocus
import team.study.presentation.ui.components.NaverBookSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen() {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clearFocus(focusManager),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var searchValue by remember { mutableStateOf("") }

        NaverBookSearchBar(
            modifier = Modifier
                .focusRequester(focusRequester),
            value = searchValue,
            onClear = {
                searchValue = ""
                focusManager.clearFocus()
            },
            onDone = {
                focusManager.clearFocus()
            },
            onValueChanged = { query ->
                searchValue = query
            },
        )

        TextField(
            modifier = Modifier,
            value = "HIHIHI",
            onValueChange = {},
            enabled = false,
        )
    }
}
