package com.example.remed.features

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.remed.R
import com.example.remed.navigation.Screens
import com.example.remed.ui.theme.ReMedTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun OnBoardingScreen(navController: NavController) {

    Column(Modifier.fillMaxSize()) {
        ImageWithAppName(    shape = MaterialTheme.shapes.large,
            elevation = 0.dp,
            aspectRatio = 1.25f) {
            Image(painterResource(id = R.drawable.ornamen_background_image),
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                modifier = Modifier.fillMaxSize())
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Manage Your Daily \nmedication intake \neasily with ReMed",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = "Simple add, remind, done. \nAll your meds can be organized here",
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.height(24.dp))
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            FloatingActionButton(
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = { navController.navigate(Screens.Home.title)},) {
                Image(painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = null, )
            }
        }
    }
}


@Composable
fun ImageWithAppName (
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    color: Color = MaterialTheme.colors.background,
    contentColor: Color = MaterialTheme.colors.onPrimary,
    border: BorderStroke? = null,
    elevation: Dp = 0.dp,
    aspectRatio: Float = 0.75f,
    matchHeightConstraints: Boolean = false,
    content: @Composable () -> Unit
) {
    Surface(
        modifier = modifier.aspectRatio(aspectRatio, false),
        shape = shape,
        color = color,
        contentColor = contentColor,
        elevation = elevation,
        border = border,
        content =  {
            Box(contentAlignment = Alignment.TopEnd){
                content()
            }
        }
    )
}

@Composable
@Preview
fun PreviewImage() {
    /*ReMedTheme() {
        ImageWithAppName(    shape = RoundedCornerShape(
            topStart = 0.dp,
            topEnd = 0.dp,
            bottomEnd = 24.dp,
            bottomStart = 24.dp),
            elevation = 0.dp,
            aspectRatio = .9f) {
            Image(painterResource(id = R.drawable.ornamen_background_image),
                contentScale = ContentScale.FillBounds,
                contentDescription = null,
                modifier = Modifier.fillMaxSize())
            
            Column(
                Modifier.padding(50.dp).zIndex(1f),
                horizontalAlignment = Alignment.End

            ) {
                Text(text = "ReMed",
                    style = MaterialTheme.typography.h5)
                Text(text = "About",
                    style = MaterialTheme.typography.body1)
            }
        }
    }*/
}

