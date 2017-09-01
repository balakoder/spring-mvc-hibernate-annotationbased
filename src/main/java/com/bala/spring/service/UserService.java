package com.bala.spring.service;

import java.util.List;

import com.bala.spring.model.User;

 

public interface UserService {
    void save(User user);

    User findByUsername(String username);

    List <User>  getUserList();
}
