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
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.R
import com.example.remed.features.ReMedButton
import com.example.remed.features.presentation.components.StandardTextField
import com.example.remed.features.presentation.components.TopAppBarWithNav
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme
import java.util.*

@ExperimentalCoilApi
@Composable
fun CreateNewReMedScreen(
    navController: NavController,
    viewModel: CreateNewReMedViewModel = hiltViewModel()) {

    var reMedName by remember { mutableStateOf("") }
    var reMedInstrucions by remember { mutableStateOf("") }

    val selectedTime = remember {
        mutableStateOf("")
    }

    val startDate = remember {
        mutableStateOf("")
    }

    val endDate = remember {
        mutableStateOf("")
    }
    ConstraintLayout(modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxHeight()
        .background(ReMedTheme.colors.uiBackground)) {
        val (toolbar, body, button) = createRefs()

        TopAppBarWithNav( title = "Create new ReMed",
            navigationClick = { navController.popBackStack(Screens.Home.route, false) },
            onSettingsClick = { navController.navigate(Screens.Settings.route) },
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
                onValueChange = { reMedName = it},
                onIconClick = { })

            Spacer(modifier = Modifier.height(16.dp))
            TextFieldWithTitle(modifier = Modifier,
                title = "Instrucions",
                text = reMedInstrucions,
                trailingIcon = R.drawable.ic_edit,
                onValueChange = { reMedInstrucions = it},
                onIconClick = { })

            Spacer(modifier = Modifier.height(16.dp))
            DateTimeSection(startDate, endDate, selectedTime)
        }
        ReMedButton(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom)
                },
            onClick = {
                      viewModel.newReMed(reMedName,
                          reMedInstrucions,
                          startDate.value,
                          endDate.value,
                          selectedTime.value)
            },
            enabled = true) {
            Text("Create New",
                modifier = Modifier.padding(vertical = 8.dp),
                color = ReMedTheme.colors.uiBackground,
                style = MaterialTheme.typography.body2)
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
    onIconClick: () -> Unit
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
                        .clickable { onIconClick() }
                        .size(25.dp)
                        .padding(5.dp),
                    contentScale = ContentScale.Fit,
                )
            })
    }
}

@Composable
fun DateTimeSection(
    startDate: MutableState<String>,
    endDate: MutableState<String>,
    time: MutableState<String>
) {
    val context = LocalContext.current

    Column() {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextFieldWithTitle(
                modifier = Modifier.weight(.7f),
                title = "Start Date",
                text = startDate.value,
                trailingIcon = R.drawable.ic_calander,
                onValueChange = { },
                onIconClick = { showDatePicker({ startDate.value = it }, context) })
            Spacer(modifier = Modifier.weight(.3f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextFieldWithTitle(
                modifier = Modifier.weight(.7f),
                title = "End Date",
                text = endDate.value,
                trailingIcon = R.drawable.ic_calander,
                onValueChange = { },
                onIconClick = { showDatePicker({ endDate.value = it }, context) })
            Spacer(modifier = Modifier.weight(.3f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextFieldWithTitle(
                modifier = Modifier.weight(.7f),
                title = "Set Time",
                text = time.value,
                trailingIcon = R.drawable.ic_clock,
                onValueChange = { },
                onIconClick = { showPicker( { time.value = it },context) })
            Spacer(modifier = Modifier.weight(.3f))
        }
    }
}


fun showPicker(time: (String) -> Unit, context: Context) {

    val calender = Calendar.getInstance()
    val hour = calender[Calendar.HOUR_OF_DAY]
    val minutes = calender[Calendar.MINUTE]

    val timePickerDialog = TimePickerDialog(
        context,
        {_, hr: Int, min: Int ->
          time("$hr:$min")
        },
        hour,
        minutes,
        false)

    timePickerDialog.show()
}

fun showDatePicker(date: (String) -> Unit, context: Context) {

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    calendar.time = Date()

    val datePicker = DatePickerDialog(
        context,
        {_: DatePicker, mYear, mMonth, mDay ->
            date("$mDay/$mMonth/$mYear")
        },
        year,
        month,
        day
    )

    datePicker.show()
}
