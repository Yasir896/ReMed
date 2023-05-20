package com.example.remed.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.R
import com.example.remed.features.presentation.on_boarding.OnBoardingContent
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun OnBoardingScreen(
    takeToHomeScreen: () -> Unit
) {
    OnBoardingContent {
        takeToHomeScreen.invoke()
    }

}
