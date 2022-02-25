package com.example.instacompose.domain.usecases

import com.example.instacompose.domain.repository.AuthenticationRepository
import javax.inject.Inject

class FirebaseSignIn @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(email:String,password:String) = repository.firebaseSignIn(email, password)
}