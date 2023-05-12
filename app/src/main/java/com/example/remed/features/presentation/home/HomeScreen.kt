package com.example.remed.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.remed.R
import com.example.remed.features.presentation.components.ReminderCard
import com.example.remed.features.presentation.home.HomeViewModel
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    takeToAddNewScreen: () -> Unit,
    takeToSettingsScreen: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.getAllReMeds()
    }

    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ReMedTheme.colors.uiBackground)
    ) {

        Column(modifier = Modifier.fillMaxSize()) {
            TopBarLarge(
                onClick = takeToSettingsScreen,
                remedMessage = when (state.remeds.isEmpty()) {
                    true -> "No ReMeds Today"
                    else -> "You have ${state.remeds.size} ReMeds Today"
                }
            )

            if (state.remeds.isNotEmpty()) {

                Text(
                    modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                    color = ReMedTheme.colors.textPrimary,
                    text = "Current ReMed",
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Left
                )

                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.remeds) { reMed ->
                        ReminderCard(
                            title = reMed.title,
                            description = reMed.instructions,
                            onClick = { })
                    }
                }
            } else {
                Box(Modifier.fillMaxSize()) {
                    Text(
                        modifier = Modifier
                            .padding(horizontal = 24.dp, vertical = 16.dp)
                            .align(Alignment.Center),
                        color = ReMedTheme.colors.textPrimary,
                        text = "Nothing to show...",
                        fontWeight = FontWeight.Medium,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Left
                    )
                }
            }
        }
        BottomBarButton(modifier = Modifier.align(Alignment.BottomCenter),
            onClickNew = takeToAddNewScreen
        )
    }
}

@Composable
fun BottomBarButton(modifier: Modifier, onClickNew: () -> Unit) {
    ReMedSurface(
        modifier = modifier,
        color = ReMedTheme.colors.light
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            androidx.compose.material.FloatingActionButton(
                modifier = Modifier.defaultMinSize(minWidth = 45.dp, minHeight = 45.dp),
                backgroundColor = ReMedTheme.colors.brand,
                onClick = onClickNew
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add),
                    contentDescription = null,
                )
            }
        }

    }
}