package com.example.picpay.rest.service.impl;

import com.example.picpay.domain.entities.User;
import com.example.picpay.domain.repository.UserR;
import com.example.picpay.rest.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    private UserR userRepository;

    @Override
    public Integer save_user(User user) {
        userRepository.save(user);
        return user.getId();
    }
}
