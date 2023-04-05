package team.study.presentation.ui.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import team.study.presentation.extension.clearFocus
import team.study.presentation.ui.components.NaverBookCard
import team.study.presentation.ui.components.NaverBookSearchBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel(),
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val query by searchViewModel.query.collectAsState("")
    val books by searchViewModel.books.collectAsState(emptyList())

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clearFocus(focusManager),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NaverBookSearchBar(
            modifier = Modifier
                .focusRequester(focusRequester),
            value = query,
            onClear = {
                searchViewModel.onChangedQuery("")
                focusManager.clearFocus()
            },
            onDone = {
                searchViewModel::search
                focusManager.clearFocus()
            },
            onValueChanged = {
                searchViewModel.onChangedQuery(it)
            },
        )

        LazyColumn {
            itemsIndexed(books) { _, book ->
                NaverBookCard(
                    book = book,
                    onClick = { /*TODO*/ },
                    onFavorite = { /*TODO*/ },
                )
            }
        }
    }
}
