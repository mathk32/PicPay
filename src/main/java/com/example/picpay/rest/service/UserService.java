package com.example.picpay.rest.service;

import com.example.picpay.domain.entities.User;

public interface UserService {

    Integer save_user( User user);

    User get_user(Integer id);
}
