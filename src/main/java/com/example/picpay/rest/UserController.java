package com.example.picpay.rest;


import com.example.picpay.domain.dto.UserDTOResponse;
import com.example.picpay.domain.entities.User;
import com.example.picpay.domain.entities.enums.UserType;
import com.example.picpay.rest.exceptions.UserNotFoundException;
import com.example.picpay.rest.service.impl.UserServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)

    public Integer create_user(@RequestBody @Valid User user){
        userService.save_user(user);
        return user.getId();
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTOResponse getUserById(@PathVariable Integer id){

        User user_found = userService.get_user(id);

        return UserDTOResponse.builder().id(user_found.getId())
                .name(user_found.getNome())
                .type(String.valueOf(user_found.getTipo()))
                .email(user_found.getEmail())
                .build();


    }






}
