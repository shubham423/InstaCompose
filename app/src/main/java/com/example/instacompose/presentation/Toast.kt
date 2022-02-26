package com.example.instacompose.presentation

import android.widget.Toast.makeText
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun Toast(massage:String){
    makeText(LocalContext.current,massage, Toast.LENGTH_LONG).show()
}