package com.example.remed.features

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.remed.R
import com.example.remed.features.presentation.components.ReminderCard
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme

@ExperimentalMaterialApi
@Composable
fun HomeScree(navController: NavController) {
    val context =  LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = ReMedTheme.colors.uiBackground)) {

        Column(modifier = Modifier.fillMaxSize()) {
            TopBarLarge(onClick = {
                Toast.makeText(context, "Go To Settings Clicked!", Toast.LENGTH_LONG).show()
            })

            Text(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp),
                color = ReMedTheme.colors.textPrimary,
                text = "Current ReMed",
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Left
            )
            ReminderCard(title = "Augmenten", onClick = { })

            ReminderCard(title = "Augmenten", onClick = { })

        }
        BottomBarButton(modifier = Modifier.align(Alignment.BottomCenter),
            onClickNew = { navController.navigate(Screens.CreateNew.title)}
        )
    }
}

@Composable
fun BottomBarButton(modifier: Modifier, onClickNew: () -> Unit) {
    ReMedSurface(modifier = modifier,
    color = ReMedTheme.colors.light) {

        Row(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
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