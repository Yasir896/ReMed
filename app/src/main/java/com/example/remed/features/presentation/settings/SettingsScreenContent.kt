package com.example.remed.features.presentation.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import com.example.remed.R
import com.example.remed.features.presentation.components.TopAppBarWithNav
import com.example.remed.features.presentation.create_new.TextFieldWithTitle
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme
import com.example.remed.ui.theme.SpaceMedium

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SettingsScreenContent(
    onNavClick: () -> Unit,
) {
    Scaffold(
        topBar = { TopAppBarWithNav(title = "Settings",
            navigationClick = onNavClick,
            onSettingsClick = { },
            showSettingsIcon = false,
            modifier = Modifier
        ) }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(SpaceMedium)
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                color = ReMedTheme.colors.textPrimary,
                text = "Defaults",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.Left
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.weight(.3f))
                TextFieldWithTitle(
                    modifier = Modifier.weight(.7f),
                    title = "User Name",
                    text = "",
                    trailingIcon = R.drawable.ic_calander,
                    onValueChange = {},
                    onIconClick = { })
            }
        }
    }
}