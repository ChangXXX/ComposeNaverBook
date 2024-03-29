package team.study.presentation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import team.study.domain.model.Book
import team.study.domain.usecase.BookSearchUseCase
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val bookSearchUseCase: BookSearchUseCase,
) : ViewModel() {

    private val uiState = MutableStateFlow(BooksUiState())
    val query = uiState.map { it.query }
    val books = uiState.map { it.books }
    val isError = uiState.map { it.isError }
    val toastMessage = uiState.map { it.toastMessage }
    val isLoading = uiState.map { it.isLoading }

    fun onChangedQuery(query: String) {
        uiState.update {
            it.copy(query = query)
        }
    }

    fun search() {
        viewModelScope.launch {
            Timber.tag("INIT SEARCH ::").d(uiState.value.query)
            bookSearchUseCase.invoke(
                query = uiState.value.query,
                onException = { msg ->
                    val exceptionMsg = msg ?: "알 수 없는 에러"
                    uiState.update {
                        it.copy(isError = true, toastMessage = exceptionMsg)
                    }
                },
            ).onStart {
                uiState.update {
                    it.copy(
                        isLoading = true,
                        isError = false,
                        toastMessage = "",
                    )
                }
            }.collectLatest { books ->
                uiState.update {
                    it.copy(
                        isLoading = false,
                        isError = false,
                        toastMessage = "",
                        books = books,
                    )
                }
            }
        }
    }
}

data class BooksUiState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val toastMessage: String = "",
    val books: List<Book> = emptyList(),
    val query: String = "",
)
