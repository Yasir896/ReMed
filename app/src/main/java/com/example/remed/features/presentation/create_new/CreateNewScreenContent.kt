package com.example.remed.features.presentation.create_new

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.widget.DatePicker
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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

@OptIn(ExperimentalCoilApi::class)
@Composable
fun CreateNewScreenContent(
    onNavigationClick: () -> Unit,
    onSettingsClick: () -> Unit,
    viewModel: CreateNewReMedViewModel,
) {

    Scaffold(
        topBar = { TopAppBarWithNav( title = "Create new ReMed",
            navigationClick = onNavigationClick,
            onSettingsClick = onSettingsClick,
            showSettingsIcon = true,
            modifier = Modifier
        ) },
        bottomBar = { ReMedButton(
            modifier = Modifier
                .padding(SpaceSmall)
                .fillMaxWidth(),
            onClick = {
                viewModel.newReMed()
            },
            enabled = true) {
            Text("Create New",
                modifier = Modifier.padding(vertical = SpaceSmall),
                color = ReMedTheme.colors.uiBackground,
                style = MaterialTheme.typography.body2)
        }
        }
    ) {
        Column(modifier = Modifier
            .padding(SpaceLarge)
            .fillMaxSize()
        ) {

            TextFieldWithTitle(modifier = Modifier,
                title = "Title",
                text = viewModel.nameText.value,
                trailingIcon = R.drawable.ic_edit,
                onValueChange = { viewModel.setNameText(it) },
                onIconClick = { })

            Spacer(modifier = Modifier.height(SpaceMedium))
            TextFieldWithTitle(modifier = Modifier,
                title = "Instrucions",
                text = viewModel.instructionsText.value,
                trailingIcon = R.drawable.ic_edit,
                onValueChange = { viewModel.setInstructionsText(it) },
                onIconClick = { })

            Spacer(modifier = Modifier.height(SpaceMedium))
            DateTimeSection(
                startTimeText = viewModel.startDate.value,
                endDateText = viewModel.endDate.value,
                timeText = viewModel.time.value,
                setStartDate = {viewModel.setStartDate(it)},
                setEndDate = { viewModel.setEndDate(it) },
                setTime = { viewModel.setTime(it) })
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
    startTimeText: String,
    endDateText: String,
    timeText: String,
    setStartDate: (String) -> Unit,
    setEndDate: (String) -> Unit,
    setTime: (String) -> Unit,
) {
    val context = LocalContext.current

    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextFieldWithTitle(
                modifier = Modifier.weight(.7f),
                title = "Start Date",
                text = startTimeText,
                trailingIcon = R.drawable.ic_calander,
                onValueChange = {},
                onIconClick = { showDatePicker({ setStartDate(it) }, context) })
            Spacer(modifier = Modifier.weight(.3f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextFieldWithTitle(
                modifier = Modifier.weight(.7f),
                title = "End Date",
                text = endDateText,
                trailingIcon = R.drawable.ic_calander,
                onValueChange = {},
                onIconClick = { showDatePicker({ setEndDate(it) }, context) })
            Spacer(modifier = Modifier.weight(.3f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextFieldWithTitle(
                modifier = Modifier.weight(.7f),
                title = "Set Time",
                text = timeText,
                trailingIcon = R.drawable.ic_clock,
                onValueChange = {},
                onIconClick = { showPicker( { setTime(it) },context) })
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
        { _: DatePicker, mYear, mMonth, mDay ->
            date("$mDay/$mMonth/$mYear")
        },
        year,
        month,
        day
    )

    datePicker.show()
}
