package com.example.picpay.domain.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTOResponse {

    private Integer id;
    private String name;
    private String email;
    private String type;


}
