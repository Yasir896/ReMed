package com.example.remed.features.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.remed.R
import com.example.remed.features.presentation.components.TopAppBarWithNav
import com.example.remed.features.presentation.create_new.TextFieldWithTitle
import com.example.remed.features.presentation.create_new.showDatePicker
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme
import com.example.remed.ui.theme.SpaceMedium
import java.time.format.TextStyle

@ExperimentalCoilApi
@Composable
fun Settings(
    onNavClick: () -> Unit
) {
    SettingsScreenContent {
        onNavClick.invoke()
    }
}