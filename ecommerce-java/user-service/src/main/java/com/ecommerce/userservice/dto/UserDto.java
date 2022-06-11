package com.ecommerce.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {

    private String email;
    private String name;
    private String pwd;
    private String userId;
    private LocalDateTime createdAt;

    private String encryptedPwd;

    public static UserDto requestUserToUserDto(RequestUserDto dto){
        return new UserDto(
                dto.getEmail(),
                dto.getName(),
                dto.getPwd(),
                "",
                LocalDateTime.now(),
                ""
        );
    }
}
