package com.example.remed.features.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.remed.R
import com.example.remed.ui.theme.ReMedTheme
import com.example.remed.ui.theme.SpaceMedium
import com.example.remed.ui.theme.SpaceSmall

@Composable
fun CustomDialog(
    openCustomDialog: MutableState<Boolean>,
    onExitClick: () -> Unit
) {
    Dialog(onDismissRequest = { openCustomDialog.value = false }) {
        CustomDialogUi(openCustomDialog = openCustomDialog) {
            onExitClick()
        }
    }
}


@Composable
fun CustomDialogUi(
    modifier: Modifier = Modifier,
    openCustomDialog: MutableState<Boolean>,
    onExitClick: () -> Unit
) {

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .height(170.dp)
            .width(200.dp)
            .padding(10.dp, 5.dp, 10.dp, 10.dp)
    ) {
        Column(
            modifier.background(Color.White),
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "About")

                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .clickable { onExitClick() },
                    painter = painterResource(id = R.drawable.ic_close),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(ReMedTheme.colors.light),
                    contentScale = ContentScale.Fit,
                )
            }
            Spacer(modifier = Modifier.height(SpaceSmall))
            InfoText(title = "Created by", value = "Yasir Ghafar")
            Spacer(modifier = Modifier.height(SpaceSmall))
            InfoText(title = "Version", value = "1.0.0")
        }
    }
}

@Composable
fun InfoText(title: String, value: String) {
    Column() {
        Text(text = title)
        Text(text = value)
    }
}