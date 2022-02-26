package com.example.instacompose.presentation.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instacompose.R
import com.example.instacompose.presentation.Toast
import com.example.instacompose.util.Response
import com.example.instacompose.util.Screens


@Composable
fun LoginScreen(navController: NavController, viewModel: AuthenticationViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val emailState = remember {
                mutableStateOf("")
            }
            val passwordState = remember {
                mutableStateOf("")
            }

            Image(
                painter = painterResource(id = R.drawable.ig_logo),
                contentDescription = "Login Screen Logo",
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 16.dp)
                    .padding(8.dp)
            )

            Text(
                text = "Sign In",
                modifier = Modifier.padding(10.dp),
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )
            OutlinedTextField(value = emailState.value, onValueChange = {
                emailState.value = it
            },
                modifier = Modifier.padding(10.dp),
                label = {
                    Text(text = "Enter your email:")
                }
            )

            OutlinedTextField(value = passwordState.value, onValueChange = {
                passwordState.value = it
            },
                modifier = Modifier.padding(10.dp),
                label = {
                    Text(text = "Enter your Password:")
                },
                visualTransformation = PasswordVisualTransformation()
            )
            Button(onClick = {
                viewModel.signIn(
                    email = emailState.value,
                    password = passwordState.value,
                )
            },
            modifier = Modifier.padding(8.dp)) {
                Text(text = "Sign In")
                when(val response=viewModel.signInState.value){
                    is Response.Loading->{

                    }
                    is Response.Success->{
                        if (response.data){
                            navController.navigate(Screens.FeedsScreen.route){
                                popUpTo(Screens.LoginScreen.route){
                                    inclusive=true
                                }
                            }
                        }
                        else{
                            Toast(massage = "Sing In failed")
                        }
                    }
                    is Response.Error->{
                        Toast(massage = response.message)
                    }

                }
            }

            Text(
                text = "New user? Sign Up",
                color = Color.Blue,
                modifier = Modifier.padding(8.dp)
                    .clickable {
                        navController.navigate(route = Screens.SignUpScreen.route){
                            launchSingleTop=true
                        }
                    }
            )

        }
    }
}