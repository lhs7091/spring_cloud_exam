package com.ecommerce.userservice.domain;

import com.ecommerce.userservice.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50, unique = true)
    private String email;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(nullable = false, unique = true)
    private String userId;
    @Column(nullable = false)
    private String encryptedPwd;

    public static UserEntity userDtoToUserEntity(UserDto userDto, String encryptedPwd){
        return new UserEntity(
                0L,
                userDto.getEmail(),
                userDto.getName(),
                UUID.randomUUID().toString(),
                encryptedPwd
        );
    }
}
