package com.example.remed.features.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remed.R
import com.example.remed.ui.theme.ReMedTheme


@ExperimentalMaterialApi
@Composable
fun ReminderCard(title: String,
                 description: String,
                 onClick: () -> Unit) {
    Card(modifier = Modifier
        .padding(12.dp)
        .fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        elevation = 1.dp,
        backgroundColor = ReMedTheme.colors.light,
        contentColor = ReMedTheme.colors.light,
        onClick = onClick) {
            Column(modifier = Modifier.padding(8.dp)) {

                CardHeader(title = title,
                    modifier = Modifier.padding(8.dp))

                CardBody(text = description,
                    modifier = Modifier.padding(8.dp))

                CardFooter(modifier = Modifier.padding(8.dp)) }
    }
}


@Composable
fun CardHeader(title: String,
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
            modifier = Modifier
                .size(35.dp)
                .padding(8.dp),
            contentScale = ContentScale.Fit,
        )

        Image(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = null,
            colorFilter = ColorFilter.tint(ReMedTheme.colors.textPrimary),
            modifier = Modifier
                .size(35.dp)
                .padding(8.dp),
            contentScale = ContentScale.Fit,
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


@ExperimentalMaterialApi
@Composable
fun SectionCard(section: SubSection, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .testTag(section.title),
        shape = MaterialTheme.shapes.large,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
                modifier = Modifier
                    .size(84.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.h6,
                    color = ReMedTheme.colors.textPrimary,
                )
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.caption,
                )
            }
        }
    }
}


@ExperimentalMaterialApi
@Preview
@Composable
fun ReminderCardPreview() {
    ReMedTheme {
        ReminderCard(title = "Nexium", "") {

        }
    }
}

/*@ExperimentalMaterialApi
@Preview
@Composable
fun SectionCardPreview() {

    ReminderCard(title = "Nexium") {
        
    }
    
    
}*/



data class SubSection (
    val id: String,
    val title: String,
    val href: String
)
