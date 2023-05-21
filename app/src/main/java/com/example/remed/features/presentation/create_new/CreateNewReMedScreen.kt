package com.example.remed.features.presentation.create_new

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.remed.R
import com.example.remed.features.ReMedButton
import com.example.remed.features.presentation.components.StandardTextField
import com.example.remed.features.presentation.components.TopAppBarWithNav
import com.example.remed.ui.theme.ReMedTheme
import com.example.remed.ui.theme.SpaceLarge
import com.example.remed.ui.theme.SpaceMedium
import com.example.remed.ui.theme.SpaceSmall
import java.util.*

@ExperimentalCoilApi
@Composable
fun CreateNewReMedScreen(
    onNavigationClick: () -> Unit,
    onSettingsClick: () -> Unit,
    viewModel: CreateNewReMedViewModel = hiltViewModel()) {

    CreateNewScreenContent(
        onNavigationClick = { onNavigationClick.invoke() },
        onSettingsClick = { onSettingsClick.invoke() },
        viewModel = viewModel
    )
}