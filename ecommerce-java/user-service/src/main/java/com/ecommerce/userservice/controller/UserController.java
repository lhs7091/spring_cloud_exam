package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.service.UserService;
import com.ecommerce.userservice.dto.RequestUserDto;
import com.ecommerce.userservice.dto.ResponseUser;
import com.ecommerce.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private final Environment env;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status(){
        return "It's Working in User Service";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return env.getProperty("greeting.message");
    }

    @PostMapping("/users")
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUserDto user){
        UserDto userDto = UserDto.requestUserToUserDto(user);
        ResponseUser responseUser = ResponseUser.userEntityToResponseUser(userService.createUser(userDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
    }


}
