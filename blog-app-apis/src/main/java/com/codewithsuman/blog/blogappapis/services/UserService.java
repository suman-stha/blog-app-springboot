package com.codewithsuman.blog.blogappapis.services;

import java.util.List;

import com.codewithsuman.blog.blogappapis.payloads.UserDto;

public interface UserService {
    // Inside interface all methods are automatically public so no need to write
    // public keywords
    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer userId);

    List<UserDto> getAllUsers();

    void deleteUser(Integer userId);

}