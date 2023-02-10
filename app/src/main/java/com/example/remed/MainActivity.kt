package com.example.remed

import android.animation.ObjectAnimator
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.example.remed.navigation.AppNavigation
import com.example.remed.ui.theme.ReMedTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialApi
@ExperimentalCoilApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
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
            val navController = rememberAnimatedNavController()
            ThemeHandler(navController)
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
                AppNavigation(navController = navController)
            }
        }
    }
}

}