package com.example.userservice.dto

import com.example.userservice.domain.UserEntity
import java.time.LocalDateTime

data class UserDto(
    val email: String,
    val name: String,
    val pwd: String,
    val userId: String,
    val createdAt: LocalDateTime?,
    val encryptedPwd: String,
    val orders: MutableList<ResponseOrder> = mutableListOf()

){
    constructor(dto: RequestUserDto)
            :this(
                dto.email,
                dto.name,
                dto.pwd,
                "",
                LocalDateTime.now(),
                ""
            )
    constructor(userEntity: UserEntity)
            :this(
                userEntity.email,
                userEntity.name,
                "",
                userEntity.userId,
                userEntity.createdAt,
                userEntity.encryptedPwd,
            )
}
