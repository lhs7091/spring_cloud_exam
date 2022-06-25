package com.example.userservice.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RequestLogin(
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be grater than 2 characters")
    @Email
    val email: String="",
    @NotNull(message = "password cannot be null")
    @Size(min = 8, message = "Password not be grater than 8 characters")
    val password: String=""
)
