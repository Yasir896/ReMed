package com.example.remed.features

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.remed.R
import com.example.remed.ui.theme.ReMedTheme

@Composable
fun TopBarLarge(onClick: () -> Unit, remedMessage: String) {
    ImageContainerWithContent(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        R.drawable.top_bar_bg,) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)) {
            Column(Modifier.fillMaxWidth()) {
                Text(text = "TuesDay, August 28, 2022",
                    color = ReMedTheme.colors.light,
                    style = MaterialTheme.typography.subtitle2)

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Hi Charles",
                    color = ReMedTheme.colors.light,
                    style = MaterialTheme.typography.h6)

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = remedMessage,
                        color = ReMedTheme.colors.light,
                        style = MaterialTheme.typography.subtitle1)
                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        modifier = Modifier
                            .size(35.dp)
                            .clickable { onClick() },
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = null,
                        colorFilter = ColorFilter.tint(ReMedTheme.colors.light),
                        contentScale = ContentScale.Fit,
                    )
                }
            }
        }
    }
}