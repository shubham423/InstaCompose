package com.example.instacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.instacompose.presentation.SplashScreen
import com.example.instacompose.presentation.authentication.AuthenticationViewModel
import com.example.instacompose.presentation.authentication.LoginScreen
import com.example.instacompose.presentation.authentication.SignUpScreen
import com.example.instacompose.presentation.main.FeedScreen
import com.example.instacompose.presentation.main.ProfileScreen
import com.example.instacompose.presentation.main.SearchScreen
import com.example.instacompose.ui.theme.InstaComposeTheme
import com.example.instacompose.util.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val authenticationViewModel: AuthenticationViewModel = hiltViewModel()
                    instaComposeApp(
                        navController = navController,
                        authenticationViewModel = authenticationViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun instaComposeApp(
    navController: NavHostController,
    authenticationViewModel: AuthenticationViewModel
) {
    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController = navController, viewModel = authenticationViewModel)
        }

        composable(route = Screens.SignUpScreen.route) {
            SignUpScreen(navController = navController, viewModel = authenticationViewModel)
        }

        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController = navController, authViewModel = authenticationViewModel)
        }

        composable(route = Screens.FeedsScreen.route) {
            FeedScreen(navController = navController)
        }

        composable(route = Screens.SearchScreen.route) {
            SearchScreen(navController = navController)
        }
        composable(route = Screens.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }

    }
}
