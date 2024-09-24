package com.example.picpay.rest;


import com.example.picpay.domain.entities.User;
import com.example.picpay.domain.entities.enums.UserType;
import com.example.picpay.domain.repository.UserR;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserR userRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer create_user(@RequestBody @Valid User user){
        if(user.getTipo() == null){
            user.setTipo(UserType.COMUM);
        }
        userRepository.save(user);
        return user.getId();
    }

}
