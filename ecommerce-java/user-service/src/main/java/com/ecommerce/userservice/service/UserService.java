package com.ecommerce.userservice.service;

import com.ecommerce.userservice.domain.UserEntity;
import com.ecommerce.userservice.dto.UserDto;

public interface UserService {
    UserEntity createUser(UserDto userDto);
    UserEntity getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
}
