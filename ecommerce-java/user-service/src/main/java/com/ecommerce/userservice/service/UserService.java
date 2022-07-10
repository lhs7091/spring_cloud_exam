package com.ecommerce.userservice.service;

import com.ecommerce.userservice.domain.UserEntity;
import com.ecommerce.userservice.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    UserEntity createUser(UserDto userDto);
    UserEntity getUserByUserId(String userId);
    Iterable<UserEntity> getUserByAll();
    UserDto getUserDetailsByEmail(String username);
}
