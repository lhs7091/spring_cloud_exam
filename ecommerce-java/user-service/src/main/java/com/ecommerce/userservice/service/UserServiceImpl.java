package com.ecommerce.userservice.service;

import com.ecommerce.userservice.domain.UserEntity;
import com.ecommerce.userservice.repository.UserRepository;
import com.ecommerce.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserEntity createUser(UserDto userDto) {
        UserEntity userEntity = UserEntity.userDtoToUserEntity(userDto, passwordEncoder.encode(userDto.getPwd()));
        return userRepository.save(userEntity);
    }
}
