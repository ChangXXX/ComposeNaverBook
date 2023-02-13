package team.study.presentation.ui.navermovie.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import team.study.presentation.ui.log.LogScreen
import team.study.presentation.ui.search.SearchScreen
import team.study.presentation.ui.theme.ThemeScreen

@Composable
fun NaverMovieNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NaverMovieDestination.SearchDestination.route,
        modifier = modifier,
    ) {
        composable(route = NaverMovieDestination.SearchDestination.route) {
            SearchScreen()
        }
        composable(route = NaverMovieDestination.LogDestination.route) {
            LogScreen()
        }
        composable(route = NaverMovieDestination.ThemeDestination.route) {
            ThemeScreen()
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) =
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id,
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
