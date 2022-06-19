package com.ecommerce.userservice.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class RequestLogin {
    @NotNull(message = "Email connot be null")
    @Size(min = 2, message = "Email not be grater than 2 characters")
    @Email
    private String email;
    @NotNull(message = "password connot be null")
    @Size(min = 8, message = "Password not be grater than 8 characters")
    private String password;
}
