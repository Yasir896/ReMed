package com.example.remed.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.example.remed.features.HomeScreen
import com.example.remed.features.OnBoardingScreen
import com.example.remed.features.presentation.create_new.CreateNewReMedScreen

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun AppNavigation(navController: NavHostController) {
        NavHost(navController = navController,
            startDestination = Screens.OnBoarding.title) {

            composable(Screens.OnBoarding.title) {
                OnBoardingScreen(navController = navController)
            }
            composable(Screens.Home.title) {
                HomeScreen(navController = navController)
            }
            composable(Screens.CreateNew.title) {
                CreateNewReMedScreen(navController = navController)
            }
        }
}