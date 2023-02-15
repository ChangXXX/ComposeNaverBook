package team.study.presentation.ui.navermovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import team.study.presentation.theme.MagentaTheme
import team.study.presentation.ui.components.NaverMovieTabRow
import team.study.presentation.ui.navermovie.navigation.NaverMovieDestination
import team.study.presentation.ui.navermovie.navigation.NaverMovieNavHost
import team.study.presentation.ui.navermovie.navigation.naverMovieScreens
import team.study.presentation.ui.navermovie.navigation.navigateSingleTopTo

@AndroidEntryPoint
class NaverMovieActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            MovieSearchApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieSearchApp() {
    MagentaTheme {
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
