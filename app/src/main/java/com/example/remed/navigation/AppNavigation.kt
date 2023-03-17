package com.example.remed.navigation

import androidx.compose.animation.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.features.HomeScreen
import com.example.remed.features.OnBoardingScreen
import com.example.remed.features.presentation.create_new.CreateNewReMedScreen
import com.example.remed.features.presentation.settings.Settings
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun AppNavigation(navController: NavHostController) {
        AnimatedNavHost(navController = navController,
            startDestination = Screens.OnBoarding.route) {


            composable(route = Screens.OnBoarding.route,
            enterTransition = { tabEnterTransition() },
            exitTransition = { tabExitTransition() }) {
                OnBoardingScreen {
                    navController.navigate(Screens.Home.route)
                }
            }
            composable(Screens.Home.route,
                enterTransition = { tabEnterTransition() },
                exitTransition = { tabExitTransition() }) {
                HomeScreen(
                    takeToAddNewScreen = { navController.navigate(Screens.CreateNew.route) },
                    takeToSettingsScreen = { navController.navigate(Screens.Settings.route) }
                )
            }
            composable(Screens.CreateNew.route,
                enterTransition = { tabEnterTransition() },
                exitTransition = { tabExitTransition() }) {
                CreateNewReMedScreen(navController = navController)
            }
            composable(Screens.Settings.route,
                enterTransition = { tabEnterTransition() },
                exitTransition = { tabExitTransition() }) {
                Settings(navController = navController)
            }
        }
}

/*private fun tabExitTransition(
    duration: Int = 500
) = fadeOut(tween(duration / 2, easing = LinearEasing))

private fun tabEnterTransition(
    duration: Int = 500, delay: Int = duration - 350
) = fadeIn(tween(duration, duration - delay))*/

private fun tabExitTransition() = slideOutHorizontally(targetOffsetX = { 6000 })
private fun tabEnterTransition() = slideInHorizontally( initialOffsetX = { 6000 })
