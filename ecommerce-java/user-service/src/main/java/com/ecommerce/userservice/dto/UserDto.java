package com.ecommerce.userservice.dto;

import com.ecommerce.userservice.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    private List<ResponseOrder> orders;

    public static UserDto requestUserToUserDto(RequestUserDto dto){
        return new UserDto(
                dto.getEmail(),
                dto.getName(),
                dto.getPwd(),
                "",
                LocalDateTime.now(),
                "",
                new ArrayList<>()
        );
    }

    public static UserDto userEntityToUserDto(UserEntity userEntity){
        return new UserDto(
                userEntity.getEmail(),
                userEntity.getName(),
                "",
                userEntity.getUserId(),
                LocalDateTime.now(),
                userEntity.getEncryptedPwd(),
                new ArrayList<>()
        );
    }
}
