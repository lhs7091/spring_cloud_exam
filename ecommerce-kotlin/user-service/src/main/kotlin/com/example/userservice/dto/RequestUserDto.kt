package com.example.userservice.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RequestUserDto(
    @NotNull(message = "Email connot be null")
    @Size(min=2, message = "Email not be less than two characters")
    @Email
    val email: String,
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    val name: String,
    @NotNull(message = "Password cannot be null")
    @Size(min=8, message = "password not be less than 8 characters")
    val pwd: String
)