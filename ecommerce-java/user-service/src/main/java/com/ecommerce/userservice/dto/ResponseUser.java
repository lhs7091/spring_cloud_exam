package com.ecommerce.userservice.dto;

import com.ecommerce.userservice.domain.UserEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseUser {
    private String email;
    private String name;
    private String userId;

    private List<ResponseOrder> orders;


    public static ResponseUser userEntityToResponseUser(UserEntity userEntity){
        return new ResponseUser(
                userEntity.getEmail(),
                userEntity.getName(),
                userEntity.getUserId(),
                new ArrayList<>()
        );
    }
}
