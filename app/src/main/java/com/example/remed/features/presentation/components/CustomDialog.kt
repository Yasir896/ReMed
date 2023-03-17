package com.example.remed.features.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

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
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp)
    ) {
        Column(
            modifier.background(Color.White),
        ) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "About")
            }
        }
    }
}