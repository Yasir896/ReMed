package com.example.remed.features.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.features.presentation.components.TopAppBarWithNav
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme

@ExperimentalCoilApi
@Composable
fun Settings(
    navController: NavController,
) {
    ConstraintLayout(modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxHeight()
        .background(ReMedTheme.colors.uiBackground)) {
        val (toolbar, body) = createRefs()

        TopAppBarWithNav( title = "Settings",
            navigationClick = { navController.popBackStack(Screens.Home.route, false) },
            onSettingsClick = {  },
            showSettingsIcon = false,
            modifier = Modifier.constrainAs(toolbar) {
                top.linkTo(parent.top)
                bottom.linkTo(body.top)

            }
        )

        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
            .constrainAs(body) {
                top.linkTo(toolbar.bottom)
                bottom.linkTo(parent.bottom)
            }) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "No Settings yet",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.primary,
                textAlign = TextAlign.Center
            )
        }
    }
}