package com.example.picpay.rest.service.impl;

import com.example.picpay.domain.entities.User;
import com.example.picpay.domain.entities.enums.UserType;
import com.example.picpay.domain.repository.UserR;
import com.example.picpay.rest.exceptions.UserAlreadyExistsException;
import com.example.picpay.rest.exceptions.UserNotFoundException;
import com.example.picpay.rest.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserR userRepository;

    @Transactional
    @Override
    public Integer save_user(User user) {

        if(user.getTipo() == null){
            user.setTipo(UserType.COMUM);
        }

        validateUser(user);

        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User get_user(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuario nao encontrado"));
    }


    private void validateUser(User user){
        List<String> errors = new ArrayList<>();

        if(userRepository.existsBycpf(user.getCpf())){
            errors.add("CPF ja cadastrado.");
        }

        if(userRepository.existsByemail(user.getEmail())){
            errors.add("EMAIL ja cadastrado.");
        }

        if(!errors.isEmpty()){
            throw new UserAlreadyExistsException(errors);
        }

    }
}
