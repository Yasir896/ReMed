package com.example.remed.features.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.features.presentation.components.TopAppBarWithNav
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme
import com.example.remed.ui.theme.SpaceMedium
import java.time.format.TextStyle

@ExperimentalCoilApi
@Composable
fun Settings(
    navController: NavController,
) {
    ConstraintLayout(
        modifier = Modifier
            .padding(top = SpaceMedium)
            .fillMaxHeight()
            .background(ReMedTheme.colors.uiBackground)
    ) {
        val (toolbar, body) = createRefs()

        TopAppBarWithNav(title = "Settings",
            navigationClick = { navController.popBackStack(Screens.Home.route, false) },
            onSettingsClick = { },
            showSettingsIcon = false,
            modifier = Modifier.constrainAs(toolbar) {
                top.linkTo(parent.top)
                bottom.linkTo(body.top)

            }
        )

        Column(modifier = Modifier.fillMaxSize().padding(SpaceMedium)
            .constrainAs(body) {
                top.linkTo(toolbar.bottom)
                bottom.linkTo(parent.bottom)
            }) {
            Text(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                color = ReMedTheme.colors.textPrimary,
                text = "Defaults",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Left
            )
        }
    }
}