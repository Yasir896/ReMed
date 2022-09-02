package com.example.remed.features.create_new

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.R
import com.example.remed.features.components.StandardTextField
import com.example.remed.features.components.TopAppBarWithNav
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme

@ExperimentalCoilApi
@Composable
fun CreateNewReMedScreen(navController: NavController) {
    var reMedName by remember { mutableStateOf("") }
    var reMedInstrucions by remember { mutableStateOf("") }


    ConstraintLayout(modifier = Modifier
        .fillMaxSize()
        .background(ReMedTheme.colors.uiBackground)) {

        val (toolbar, body) = createRefs()

        TopAppBarWithNav( title = "Create new ReMed",
            navigationClick = { navController.popBackStack(Screens.Home.title, false) },
            onSettingsClick = {  },
            showSettingsIcon = true,
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
            TextFieldWithTitle(modifier = Modifier,
                title = "Title",
                text = reMedName,
                trailingIcon = R.drawable.ic_edit,
                onValueChange = { reMedName = it})

            Spacer(modifier = Modifier.height(16.dp))
            TextFieldWithTitle(modifier = Modifier,
                title = "Instrucions",
                text = reMedInstrucions,
                trailingIcon = R.drawable.ic_edit,
                onValueChange = { reMedInstrucions = it})

            Spacer(modifier = Modifier.height(16.dp))
            DateTimeSection(startDate = "02 SEP 2022", endDate = "02 SEP 2022" )
        }
    }
}

@Composable
fun TextFieldWithTitle(
    modifier: Modifier,
    title: String,
    text: String,
    trailingIcon: Int,
    onValueChange: (String) -> Unit,
    ) {
    
    Column(modifier = modifier) {
        Text(
            text = title,
            modifier = Modifier,
            style = MaterialTheme.typography.body1,
            color = ReMedTheme.colors.textSecondary,
        )
        StandardTextField(
            text = text,
            onValueChange = { onValueChange(it) },
            modifier = Modifier,
            trailingIcon = {
                Image(
                    painter = painterResource(id = trailingIcon),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(ReMedTheme.colors.textPrimary),
                    modifier = Modifier
                        .size(30.dp)
                        .padding(8.dp),
                    contentScale = ContentScale.Fit,
                )
            })
    }
}

@Composable
fun DateTimeSection(startDate: String, endDate: String) {
    Column() {
        Row(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(.4f)) {
                TextFieldWithTitle(
                    modifier = Modifier,
                    title = "Start Date",
                    text = startDate,
                    trailingIcon = R.drawable.ic_calander,
                    onValueChange = { })
            }
            Spacer(modifier = Modifier.weight(.2f))
            Row(Modifier.weight(.4f)) {
                TextFieldWithTitle(
                    modifier = Modifier,
                    title = "End Date",
                    text = endDate,
                    trailingIcon = R.drawable.ic_calander,
                    onValueChange = { })
            }


        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(Modifier.fillMaxWidth()) {
            Row(Modifier.weight(.4f)) {
                TextFieldWithTitle(
                    modifier = Modifier,
                    title = "Start Date",
                    text = startDate,
                    trailingIcon = R.drawable.ic_clock,
                    onValueChange = { })
            }
            Spacer(modifier = Modifier.weight(.2f))
            Row(Modifier.weight(.4f)) {
                TextFieldWithTitle(
                    modifier = Modifier,
                    title = "End Date",
                    text = endDate,
                    trailingIcon = R.drawable.ic_calander,
                    onValueChange = { })
            }
        }
    }
}


@Composable
@Preview
fun PreviewDateSection() {
    ReMedTheme {
        DateTimeSection(startDate = "02 SEP 2022", endDate = "02 SEP 2022" )
    }
}