package team.study.presentation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import team.study.domain.model.Book
import team.study.domain.usecase.BookSearchUseCase
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val bookSearchUseCase: BookSearchUseCase,
) : ViewModel() {

    private val uiState = MutableStateFlow(BooksUiState())
    val query = uiState.map { it.query }
    val books = uiState.map { it.books }

    fun onChangedQuery(query: String) {
        uiState.update {
            it.copy(query = query)
        }
    }

    fun search() {
        viewModelScope.launch {
            bookSearchUseCase.invoke(uiState.value.query, {})
                .map { books ->
                    uiState.update { it.copy(books = books) }
                }.collect()
        }
    }
}

data class BooksUiState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val error: Throwable? = null,
    val books: List<Book> = emptyList(),
    val query: String = "",
)
