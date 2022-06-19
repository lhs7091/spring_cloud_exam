package com.example.userservice.service

import com.example.userservice.domain.UserEntity
import com.example.userservice.dto.UserDto
import com.example.userservice.repository.UserRepository
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: BCryptPasswordEncoder
) {

    fun createUser(userDto: UserDto): UserEntity{
        val userEntity = UserEntity(userDto, passwordEncoder.encode(userDto.pwd))
        return userRepository.save(userEntity)
    }

    fun getUserByUserId(userId: String): UserEntity{
        val userEntity = userRepository.findByUserId(userId)
        return userEntity.orElseGet { throw UsernameNotFoundException("User not Found") }
    }

    fun getUserByAll(): List<UserEntity> = userRepository.findAll()
}