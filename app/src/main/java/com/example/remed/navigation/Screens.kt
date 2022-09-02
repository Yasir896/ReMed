package com.example.remed.navigation

sealed class Screens(val title: String) {
    object OnBoarding: Screens("on_boarding_screen")
    object Home: Screens("home_screen")
    object Settings: Screens("settings_screen")
    object CreateNew: Screens("create_new_screen")
}
