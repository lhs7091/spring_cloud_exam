package com.example.userservice.dto

import com.example.userservice.domain.UserEntity

data class ResponseUser(
    val email: String,
    val name: String,
    val userId: String,
    val orders: List<ResponseOrder>
) {
    constructor(userEntity: UserEntity):this(
        userEntity.email, userEntity.name, userEntity.userId, arrayListOf()
    )
}
