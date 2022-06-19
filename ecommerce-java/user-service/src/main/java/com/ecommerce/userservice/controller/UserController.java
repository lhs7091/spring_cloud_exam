package com.ecommerce.userservice.controller;

import com.ecommerce.userservice.domain.UserEntity;
import com.ecommerce.userservice.service.UserService;
import com.ecommerce.userservice.dto.RequestUserDto;
import com.ecommerce.userservice.dto.ResponseUser;
import com.ecommerce.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private final Environment env;
    private final UserService userService;

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service on Port %s", env.getProperty("local.server.port"));
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

    @GetMapping("/users")
    public ResponseEntity<List<ResponseUser>> getUsers(){
        Iterable<UserEntity> userList = userService.getUserByAll();
        List<ResponseUser> res = new ArrayList<>();

        userList.forEach(v-> res.add(ResponseUser.userEntityToResponseUser(v)));
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable String userId){
        UserEntity userEntity = userService.getUserByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseUser.userEntityToResponseUser(userEntity));
    }

}
