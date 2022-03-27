package com.example.helloword.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {
    private String username;
    private String password;
    private Integer age;

    public User(String username, String password, int age) {
        this.username=username;
        this.password=password;
        this.age=age;
    }
}
