package team.study.presentation.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import team.study.domain.model.UserPreference.ThemeType
import team.study.domain.usecase.GetThemeUseCase
import team.study.domain.usecase.UpdateThemeUseCase
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    getThemeUseCase: GetThemeUseCase,
    private val updateThemeUseCase: UpdateThemeUseCase,
) : ViewModel() {
    val themeUiState: StateFlow<ThemeUiState> =
        getThemeUseCase.invoke()
            .map { pickedTheme ->
                ThemeUiState.Success(
                    when (pickedTheme) {
                        is ThemeType.System -> {
                            Themes.System
                        }
                        is ThemeType.Light -> {
                            Themes.Light
                        }
                        is ThemeType.Dark -> {
                            Themes.Dark
                        }
                    },
                )
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = ThemeUiState.Loading,
            )

    fun updateTheme(title: String) {
        viewModelScope.launch {
            val themeType = when (title) {
                Themes.System.name -> {
                    ThemeType.System
                }
                Themes.Light.name -> {
                    ThemeType.Light
                }
                Themes.Dark.name -> {
                    ThemeType.Dark
                }
                else -> {
                    ThemeType.System
                }
            }
            updateThemeUseCase.invoke(themeType)
        }
    }
}

sealed class Themes(val name: String) {
    object System : Themes("SYSTEM")
    object Light : Themes("LIGHT")
    object Dark : Themes("DARK")
}

sealed interface ThemeUiState {
    object Loading : ThemeUiState
    data class Success(val themes: Themes) : ThemeUiState
}
