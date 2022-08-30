package com.example.remed.features

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.remed.navigation.Screens

@ExperimentalMaterialApi
@Composable
fun HomeScree(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        TopBarLarge(onClick = { navController.popBackStack(Screens.OnBoarding.title, false) })

        ReminderCard(title = "Panadol") {

        }
    }


}