package com.abdo.coffeesystem.wrapper;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserWrapper {
    private  Integer id;
    private String name;
    private String  email;
    private String phoneNumber;
    private String status;


    }