package com.example.remed

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
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
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.features.domain.alarm.AlarmScheduler
import com.example.remed.features.domain.alarm.AlarmSchedulerImpl
import com.example.remed.features.domain.model.Alarm
import com.example.remed.features.presentation.AlarmTestScreen
import com.example.remed.features.presentation.components.CustomDialog
import com.example.remed.navigation.AppNavigation
import com.example.remed.ui.theme.ReMedTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
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

        setContent {
            installSplashScreen()
                .apply {
                    setOnExitAnimationListener { sp ->
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
                    CustomDialog(openCustomDialog = displayDialog) {
                        finish()
                    }
            }
        }

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
                    //AppNavigation(navController = navController)
                    AlarmTestScreen()
                }
            }
        }
    }

}