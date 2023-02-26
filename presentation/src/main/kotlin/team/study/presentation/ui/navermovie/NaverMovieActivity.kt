package team.study.presentation.ui.navermovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import team.study.domain.model.UserPreference
import team.study.presentation.theme.MagentaTheme
import team.study.presentation.ui.components.NaverMovieTabRow
import team.study.presentation.ui.navermovie.navigation.NaverMovieDestination
import team.study.presentation.ui.navermovie.navigation.NaverMovieNavHost
import team.study.presentation.ui.navermovie.navigation.naverMovieScreens
import team.study.presentation.ui.navermovie.navigation.navigateSingleTopTo

@AndroidEntryPoint
class NaverMovieActivity : ComponentActivity() {

    private val viewModel: NaverMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        var uiState: MainUiState by mutableStateOf(MainUiState.Loading)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.mainUiState
                    .onEach {
                        uiState = it
                    }.collect()
            }
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val isDarkTheme = shouldUseDarkTheme(uiState = uiState)
            val systemUiController = rememberSystemUiController()

            DisposableEffect(systemUiController, isDarkTheme) {
                systemUiController.systemBarsDarkContentEnabled = !isDarkTheme
                onDispose {}
            }

            MovieSearchApp(isDarkTheme)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchApp(
    darkTheme: Boolean,
) {
    MagentaTheme(
        darkTheme = darkTheme,
    ) {
        val navController = rememberNavController()
        val currentBackStack by navController.currentBackStackEntryAsState()
        val currentDestination = currentBackStack?.destination
        val currentScreen =
            naverMovieScreens.find { it.route == currentDestination?.route }
                ?: NaverMovieDestination.SearchDestination

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            contentColor = MaterialTheme.colorScheme.onBackground,
            topBar = {
                NaverMovieTabRow(
                    allScreens = naverMovieScreens,
                    onTabSelected = { newScreen ->
                        navController.navigateSingleTopTo(newScreen.route)
                    },
                    currentScreen = currentScreen,
                )
            },
        ) { paddingValues ->
            NaverMovieNavHost(
                navController = navController,
                modifier = Modifier.padding(paddingValues),
            )
        }
    }
}

@Composable
private fun shouldUseDarkTheme(
    uiState: MainUiState,
): Boolean = when (uiState) {
    is MainUiState.Loading -> {
        isSystemInDarkTheme()
    }
    is MainUiState.Success -> {
        when (uiState.theme) {
            is UserPreference.ThemeType.System -> isSystemInDarkTheme()
            is UserPreference.ThemeType.Light -> false
            is UserPreference.ThemeType.Dark -> true
        }
    }
}
