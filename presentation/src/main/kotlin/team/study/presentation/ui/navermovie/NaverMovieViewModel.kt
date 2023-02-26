package team.study.presentation.ui.navermovie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import team.study.domain.model.UserPreference.ThemeType
import team.study.domain.usecase.GetThemeUseCase
import javax.inject.Inject

@HiltViewModel
class NaverMovieViewModel @Inject constructor(
    getThemeUseCase: GetThemeUseCase,
) : ViewModel() {
    val mainUiState: StateFlow<MainUiState> =
        getThemeUseCase.invoke()
            .map { pickedTheme ->
                MainUiState.Success(
                    pickedTheme,
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = MainUiState.Loading,
            )
}

sealed interface MainUiState {
    object Loading : MainUiState
    data class Success(val theme: ThemeType) : MainUiState
}
