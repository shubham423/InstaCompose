package com.example.instacompose.util

sealed class Screens(val route:String){
    object SplashScreen : Screens("splash_screen")
    object LoginScreen  : Screens("login_screen")
    object SignUpScreen : Screens("signup_scree")
    object FeedsScreen  : Screens("feeds_screen")
}