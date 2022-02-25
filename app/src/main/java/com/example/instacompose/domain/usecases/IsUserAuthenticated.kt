package com.example.instacompose.domain.usecases

import com.example.instacompose.domain.repository.AuthenticationRepository
import javax.inject.Inject

class IsUserAuthenticated @Inject constructor(
    private val repository: AuthenticationRepository
){
    operator fun invoke() = repository.isUserAuthenticatedInFirebase()
}