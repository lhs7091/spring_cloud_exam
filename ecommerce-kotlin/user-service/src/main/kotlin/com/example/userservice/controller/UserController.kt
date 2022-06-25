package com.example.userservice.controller

import com.example.userservice.dto.RequestUserDto
import com.example.userservice.dto.ResponseUser
import com.example.userservice.dto.UserDto
import com.example.userservice.service.UserService
import org.springframework.core.env.Environment
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class UserController(
    private val env: Environment,
    private val userService: UserService
) {
    @GetMapping("/health_check")
    fun status(): String = "It's Working in User service on Port ${env.getProperty("local.server.port")}"

    @GetMapping("/welcome")
    fun welcome(): String = env.getProperty("greeting.message").toString()

    @PostMapping("/users")
    fun createUser(@RequestBody requestUserDto: RequestUserDto): ResponseEntity<ResponseUser>{
        val userDto = UserDto(requestUserDto)
        val saveUser = userService.createUser(userDto)
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseUser(saveUser))
    }

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<ResponseUser>>{
        val res = arrayListOf<ResponseUser>()
        userService.getUserByAll().forEach{
            res.add(ResponseUser(it))
        }
        return ResponseEntity.ok().body(res)
    }

    @GetMapping("/users/{userId}")
    fun getUser(@PathVariable userId: String): ResponseEntity<ResponseUser>{
        val findUser = userService.getUserByUserId(userId)
        return ResponseEntity.ok().body(ResponseUser(findUser))
    }

}