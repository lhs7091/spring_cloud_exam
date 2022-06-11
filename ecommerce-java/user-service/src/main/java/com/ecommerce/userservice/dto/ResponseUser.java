package com.ecommerce.userservice.dto;

import com.ecommerce.userservice.domain.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ResponseUser {
    private String email;
    private String name;
    private String userId;

    public static ResponseUser userEntityToResponseUser(UserEntity userEntity){
        return new ResponseUser(
                userEntity.getEmail(),
                userEntity.getName(),
                userEntity.getUserId()
        );
    }
}
