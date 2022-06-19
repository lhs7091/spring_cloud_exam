package com.example.userservice.repository

import com.example.userservice.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository: JpaRepository<UserEntity, Long> {
    fun findByUserId(userId: String): Optional<UserEntity>
}