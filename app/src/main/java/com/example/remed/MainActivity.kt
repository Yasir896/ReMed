package com.example.remed

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.features.domain.alarm.AlarmScheduler
import com.example.remed.features.domain.alarm.AlarmSchedulerImpl
import com.example.remed.features.domain.model.Alarm
import com.example.remed.navigation.AppNavigation
import com.example.remed.ui.theme.ReMedTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDateTime

@ExperimentalMaterialApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val alarmScheduler : AlarmScheduler = AlarmSchedulerImpl(this)
        var alarmTime: Alarm?

        setContent {
            ReMedTheme {

                var secondText by remember { mutableStateOf("") }
                var messageText by remember { mutableStateOf("") }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    OutlinedTextField(value = secondText, onValueChange = {
                        secondText = it
                    },
                        label = {
                            Text(text = "Delay Second")
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(value = messageText, onValueChange = {
                        messageText = it
                    },
                        label = {
                            Text(text = "Message")
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(onClick = {
                            alarmTime = Alarm(
                                alarmTime = LocalDateTime.now().plusSeconds(
                                    secondText?.toLong()
                                ),
                                message = messageText
                            )
                            alarmTime?.let { alarmScheduler::schedule }
                            secondText = ""
                            messageText = ""

                        }) {
                            Text(text = "Schedule")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = {
                            alarmScheduler::cancel
                        }) {
                            Text(text = "Cancel")
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                    }

                }

            }
        }
        /*installSplashScreen()
            .apply {
            setOnExitAnimationListener{ sp ->
                sp.iconView.animate().rotation(180F).duration = 3000L
                val slideUp = ObjectAnimator.ofFloat(
                    sp.iconView,
                    View.TRANSLATION_Y,
                    0f,
                    -sp.iconView.height.toFloat()
                )
                slideUp.interpolator = AnticipateInterpolator()
                slideUp.duration = 3000L
                // Call SplashScreenView.remove at the end of your custom animation.
                slideUp.doOnEnd {
                    sp.remove()
                }
                // Run your animation.
                slideUp.start()
        }
    }
        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {

            val displayDialog = remember {
                mutableStateOf(false)
            }

            val navController = rememberAnimatedNavController()
            ThemeHandler(navController)

            if (displayDialog.value)
                CustomDialog(openCustomDialog = displayDialog){
                    finish()
                }
        }*/
}

@ExperimentalAnimationApi
@ExperimentalCoilApi
@Composable
fun ThemeHandler(navController: NavHostController) {
    ReMedTheme {
        Scaffold {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colors.background
            ) {
                AppNavigation(navController = navController)
            }
        }
    }
}

}