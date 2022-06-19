package com.example.userservice.domain

import com.example.userservice.dto.UserDto
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val email: String,
    val name: String,
    val userId: String,
    val encryptedPwd: String,
    @CreationTimestamp
    val createdAt: LocalDateTime?,
    @UpdateTimestamp
    val updatedAt: LocalDateTime?

) {
    constructor(userDto: UserDto, encryptedPwd: String)
            : this(
        0L, userDto.email, userDto.name, UUID.randomUUID().toString(), encryptedPwd, null, null
    )
}
