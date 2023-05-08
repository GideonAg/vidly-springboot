package com.gideon.vidly.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gideon.vidly.entity.UserEntity;
import com.gideon.vidly.model.UserModel;
import com.gideon.vidly.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntity userEntity;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserModel userModel) {
        userEntity.setFirstName(userModel.getFirstName());
        userEntity.setLastName(userModel.getLastName());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepository.save(userEntity);
    }
    
}
