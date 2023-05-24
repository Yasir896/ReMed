package com.example.remed.features.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remed.R
import com.example.remed.features.ReMedButton
import com.example.remed.features.domain.model.ReMed
import com.example.remed.ui.theme.ReMedTheme
import com.example.remed.ui.theme.SpaceSmall


@ExperimentalMaterialApi
@Composable
fun ReminderCard(
    reminder: ReMed,
    isCurrentReminder: Boolean = false
) {
    Card(modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        elevation = 1.dp,
        backgroundColor = ReMedTheme.colors.light,
        contentColor = ReMedTheme.colors.light,) {
            Column(modifier = Modifier.padding(8.dp)) {

                CardHeader(title = reminder.title,
                    modifier = Modifier.padding(8.dp), onEditClick = { }, onShareClick = { })

                CardBody(text = reminder.instructions,
                    modifier = Modifier.padding(8.dp))

                CardFooter(modifier = Modifier.padding(8.dp))

                if (isCurrentReminder) {
                    RowButtons(Modifier.fillMaxWidth())
                }
            }

    }
}


@Composable
fun CardHeader(title: String,
               onShareClick: () -> Unit,
               onEditClick: () -> Unit,
               modifier: Modifier) {
    Row(
        modifier = modifier ,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            color = ReMedTheme.colors.textPrimary,
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(id = R.drawable.ic_send),
            contentDescription = null,
            colorFilter = ColorFilter.tint(ReMedTheme.colors.textPrimary),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(35.dp)
                .padding(8.dp)
                .clickable { onShareClick.invoke() },

        )

        Image(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = null,
            colorFilter = ColorFilter.tint(ReMedTheme.colors.textPrimary),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(35.dp)
                .padding(8.dp)
                .clickable { onEditClick.invoke() },
        )
    }
}

@Composable
fun CardBody(text: String,
             modifier: Modifier) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.body2,
        color = ReMedTheme.colors.textSecondary,
    )
}

@Composable
fun CardFooter(modifier: Modifier) {

    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically) {
        DateWithImage("Today", R.drawable.ic_calander)
        Spacer(modifier = Modifier.weight(1f))
        DateWithImage("09:00am", R.drawable.ic_clock)
    }
}

@Composable
fun DateWithImage(time: String,
                  icon: Int) {
    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(ReMedTheme.colors.textSecondary),
            modifier = Modifier
                .size(32.dp)
                .padding(8.dp),
            contentScale = ContentScale.Fit,
        )
        Text(
            text = time,
            modifier = Modifier,
            style = MaterialTheme.typography.body2,
            color = ReMedTheme.colors.textSecondary,
        )
    }
}


@Composable
fun RowButtons(modifier: Modifier) {
    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly) {

        ReMedButton(
            modifier = Modifier.weight(1f)
                .padding(SpaceSmall),
            onClick = { },
            enabled = true) {
            Text("Snooze",
                modifier = Modifier.padding(vertical = SpaceSmall),
                color = ReMedTheme.colors.uiBackground,
                style = MaterialTheme.typography.body2)
        }

        ReMedButton(
            modifier = Modifier.weight(1f)
                .padding(SpaceSmall),
            onClick = { },
            enabled = true) {
            Text("Done",
                modifier = Modifier.padding(vertical = SpaceSmall),
                color = ReMedTheme.colors.uiBackground,
                style = MaterialTheme.typography.body2)
        }
    }
}

/*@ExperimentalMaterialApi
@Preview
@Composable
fun ReminderCardPreview() {
    ReMedTheme {
        ReminderCard(title = "Nexium", "", isCurrentReminder = true)
    }
}*/

