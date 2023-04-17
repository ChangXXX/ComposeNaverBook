package team.study.presentation.ui.search

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalContext
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
    val context = LocalContext.current
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val query by searchViewModel.query.collectAsState("")
    val books by searchViewModel.books.collectAsState(emptyList())
    val isError by searchViewModel.isError.collectAsState(false)
    val toastMessage by searchViewModel.toastMessage.collectAsState("")

    LaunchedEffect(isError, toastMessage) {
        if (isError && toastMessage.isNotEmpty()) {
            Toast.makeText(
                context,
                toastMessage,
                Toast.LENGTH_SHORT,
            ).show()
        }
        searchViewModel.updateErrorFalse()
    }

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
                focusManager.clearFocus()
                searchViewModel.onChangedQuery("")
            },
            onDone = {
                focusManager.clearFocus()
                searchViewModel.search()
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
